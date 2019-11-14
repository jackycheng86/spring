package com.spring.user.service;

import com.spring.user.entity.UserEntity;

import java.util.List;

public interface UserService {
    void save(UserEntity userEntity) throws Exception;

    List<UserEntity> findAll() throws Exception;

    void update(UserEntity userEntity) throws Exception;

    void delete(String id) throws Exception;

    /**
     * 根据登陆帐号获取用户信息
     * @author chengjian
     * @date 2019/10/16
     * @param loginId
     * @return com.spring.user.entity.UserEntity
     */
    UserEntity findByLoginId(String loginId)throws Exception;

    void init()throws Exception;
}
