package com.spring.demo.controller1;

import com.spring.demo.entity1.FileEntity;
import com.spring.demo.service1.StorageService1;
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

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * com.spring.demo.service.controller
 *
 * @author jacky
 * @date 2017/12/23
 **/
@Controller
@RequestMapping("/file1")
public class FileController1 {
    private StorageService1 storageService;

    @Autowired
    public FileController1(StorageService1 storageService) {
        this.storageService = storageService;
    }

    @GetMapping
    public String main(Model model) {
        List<FileEntity> files = storageService.findAll();
        if (files != null && files.size() > 0) {
            List<String> paths = new ArrayList<>();
            //lambda表达式遍历list
            //利用MvcUriComponentsBuilder自动生成url
            files.forEach(fileEntity -> paths.add(MvcUriComponentsBuilder.fromMethodName(FileController1.class, "load",
                    fileEntity.getFileid(), fileEntity.getFilename() +"."+ fileEntity.getFileext()).build().toString()));
            model.addAttribute("files", paths);
        }
        return "upload1";
    }

    @GetMapping("/{fileId}/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<Resource> load(@PathVariable String fileId, @PathVariable String fileName) {
        Resource file = storageService.loadAsResource(fileId, fileName);
        try {
            //new String(fileName.getBytes("UTF-8"),"ISO8859-1") 为了解决文件名乱码
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                    "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"),"ISO8859-1") + "\"").body(file);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件上传
     * @param file
     * @param redirectAttributes
     * @return
     */
    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes) {
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "上传文件成功，" + file.getOriginalFilename() + "!");
        return "redirect:/file1";
    }
}
