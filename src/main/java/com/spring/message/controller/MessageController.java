package com.spring.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * com.spring.message.controller
 *
 * @author chengjian
 * @date 2018/1/9
 **/
@Controller
@RequestMapping
public class MessageController {
    public String main(){
        return "message";
    }
}
