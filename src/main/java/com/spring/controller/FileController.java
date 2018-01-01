package com.spring.controller;

import com.spring.entity.FileEntity;
import com.spring.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

/**
 * com.spring.controller
 *
 * @author jacky
 * @date 2017/12/23
 **/
@Controller
@RequestMapping("/file")
public class FileController {
    private StorageService storageService;

    @Autowired
    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping
    public String main(Model model) {
        List<FileEntity> files = storageService.findAll();
        if (files != null && files.size() > 0) {
            System.out.println(files.size());
            List<String> paths = new ArrayList<>();
            files.forEach(fileEntity -> paths.add(MvcUriComponentsBuilder.fromMethodName(FileController.class, "load",
                    fileEntity.getFileid(), fileEntity.getFilename() +"."+ fileEntity.getFileext()).build().toString()));
            model.addAttribute("files", paths);
        }
        return "upload";
    }

    @GetMapping("/{fileId}/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<Resource> load(@PathVariable String fileId, @PathVariable String fileName) {
        Resource file = storageService.loadAsResource(fileId, fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + fileName + "\"").body(file);
    }

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "上传文件成功，" + file.getOriginalFilename() + "!");
        return "redirect:/file";
    }
}
