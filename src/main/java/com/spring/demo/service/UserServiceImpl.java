package com.spring.demo.service;

import com.spring.common.service.BaseServiceImpl;
import com.spring.demo.entity.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.spring.service
 * cj
 * 2017/12/23
 **/
@Service
@Transactional(readOnly = true,transactionManager = "transactionManager")
public class UserServiceImpl extends BaseServiceImpl<UserEntity,String> implements UserService{
}
