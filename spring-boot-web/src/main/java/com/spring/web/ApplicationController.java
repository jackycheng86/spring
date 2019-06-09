package com.spring.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author chengjian
 * @date 2019-06-03
 */
@Controller
@RequestMapping("/")
public class ApplicationController {

    @GetMapping
    public String main(Map<String,Object> model){
        model.put("hello","Hello World!");
        return "main";
    }
}
