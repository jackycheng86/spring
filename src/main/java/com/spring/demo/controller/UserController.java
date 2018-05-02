package com.spring.demo.controller;

import com.spring.demo.entity.UserEntity;
import com.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * com.spring.demo.service.controller
 * cj
 * 2017/12/23
 **/
@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public List<UserEntity> list(){
        try {
            return userService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
