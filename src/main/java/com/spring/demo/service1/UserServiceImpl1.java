package com.spring.demo.service1;

import com.spring.common.service.BaseServiceImpl;
import com.spring.demo.entity1.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.spring.service
 * cj
 * 2017/12/23
 **/
@Service
@Transactional(readOnly = true,transactionManager = "transactionManager1")
public class UserServiceImpl1 extends BaseServiceImpl<UserEntity,String> implements UserService1 {
}
