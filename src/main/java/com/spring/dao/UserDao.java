package com.spring.dao;

import com.spring.common.dao.MyBaseRepository;
import com.spring.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * com.spring.dao
 * cj
 * 2017/12/23
 **/
@Repository
public interface UserDao extends MyBaseRepository<UserEntity, String> {
}
