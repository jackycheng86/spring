package com.spring.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String home() {
        System.out.println("homecontroller");
        return "redirect:swagger-ui.html";
    }
}
