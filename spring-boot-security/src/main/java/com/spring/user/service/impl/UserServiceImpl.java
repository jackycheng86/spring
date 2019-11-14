package com.spring.user.service.impl;

import com.spring.user.dao.UserDao;
import com.spring.user.entity.UserEntity;
import com.spring.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    public void save(UserEntity userEntity) throws Exception {
        System.out.println(userEntity.toString());
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

    /**
     * 根据登陆帐号获取用户信息
     *
     * @param loginId
     * @return com.spring.user.entity.UserEntity
     * @author chengjian
     * @date 2019/10/16
     */
    @Override
    public UserEntity findByLoginId(String loginId) throws Exception{
        return userDao.findTopByLoginId(loginId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    public void init() throws Exception {
        UserEntity userEntity=new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setLoginId("admin");
        userEntity.setLoginPwd(bCryptPasswordEncoder.encode("admin"));
        userEntity.setUserName("管理员");
        System.out.println(userEntity.toString());
        save(userEntity);
    }
}
