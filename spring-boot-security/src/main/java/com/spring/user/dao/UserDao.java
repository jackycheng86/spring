package com.spring.user.dao;

import com.spring.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {

    /**
     * 根据登陆帐号获取用户信息
     * @author chengjian
     * @date 2019/10/16
     * @param loginId
     * @return com.spring.user.entity.UserEntity
     */
    UserEntity findTopByLoginId(String loginId);
}
