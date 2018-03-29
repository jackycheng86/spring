package com.spring.demo.controller1;

import com.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * com.spring.demo.service.controller
 * cj
 * 2017/12/23
 **/
@Controller
@RequestMapping("/user1")
public class UserController1 {
    private UserService userService;

    @Autowired
    public UserController1(UserService userService) {
        this.userService = userService;
    }
}
