package com.spring.demo.dao;

import com.spring.common.dao.MyBaseRepository;
import com.spring.demo.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * com.spring.dao
 * cj
 * 2017/12/23
 **/
@Repository
public interface UserDao extends MyBaseRepository<UserEntity, String> {
}
