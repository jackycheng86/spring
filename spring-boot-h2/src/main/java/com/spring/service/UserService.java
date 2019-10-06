package com.spring.service;

import com.spring.entity.UserEntity;

import java.util.List;

public interface UserService {

    void save(UserEntity userEntity) throws Exception;

    List<UserEntity> findAll() throws Exception;

    void update(UserEntity userEntity) throws Exception;

    void delete(String id) throws Exception;
}
