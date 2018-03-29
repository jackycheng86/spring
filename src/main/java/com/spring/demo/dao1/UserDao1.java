package com.spring.demo.dao1;

import com.spring.common.dao.MyBaseRepository;
import com.spring.demo.entity1.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * com.spring.dao
 * cj
 * 2017/12/23
 **/
@Repository
public interface UserDao1 extends MyBaseRepository<UserEntity, String> {
}
