package com.spring.controller;

import com.spring.entity.FileEntity;
import com.spring.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * com.spring.controller
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
    public String main(Model model){
        List<FileEntity> files=storageService.findAll();
        if(files!=null&&files.size()>0){
            model.addAttribute("files",files);
        }
        return "upload";
    }

    public String upload(@RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes){
        storageService.s
    }
}
