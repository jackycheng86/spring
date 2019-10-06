package com.spring.controller;

import com.spring.entity.UserEntity;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> page(){
        try {
            return userService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/save")
    public String save(){
        UserEntity userEntity=new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setLoginId("abc");
        userEntity.setLoginPwd("123");
        userEntity.setUserName("abc");
        try {
            userService.save(userEntity);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
