package com.spring.security.service;

import com.spring.user.entity.UserEntity;
import com.spring.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserLoginServiceImpl implements UserDetailsService {

    private UserService userService;

    @Autowired
    public UserLoginServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity= null;
        try {
            userEntity = userService.findByLoginId(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(userEntity!=null){
            return User.builder().username(userEntity.getLoginId()).password(userEntity.getLoginPwd()).roles("USER").build();
        }
        return null;
    }
}
