package com.spring.service.impl;

import com.spring.dao.UserDao;
import com.spring.entity.UserEntity;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    public void save(UserEntity userEntity) throws Exception {
        userDao.save(userEntity);
    }

    @Override
    public List<UserEntity> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    public void update(UserEntity userEntity) throws Exception {
        userDao.saveAndFlush(userEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    public void delete(String id) throws Exception {
        userDao.deleteById(id);
    }
}
