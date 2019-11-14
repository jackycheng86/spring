package com.spring.user.controller;

import com.spring.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 初始化登陆用户
     * @author chengjian
     * @date 2019/10/16
     * @return java.lang.String
     */
    @GetMapping("/init")
    public String init(){
        try {
            userService.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
