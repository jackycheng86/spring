package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class DemoFilterController {

    @GetMapping("/demo")
    public String demo(){
        return "demoFilter测试！";
    }

    @GetMapping("/bean")
    public String demoBean(){
        return "demoBeanFilter测试！";
    }
}
