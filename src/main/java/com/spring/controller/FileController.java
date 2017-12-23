package com.spring.controller;

import com.spring.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * com.spring.controller
 * cj
 * 2017/12/23
 **/
@Controller
@RequestMapping("/file")
public class FileController {
    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }
}
