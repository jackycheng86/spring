package com.spring.demo.service;

import com.spring.common.service.BaseServiceImpl;
import com.spring.demo.dao.UserDao;
import com.spring.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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


    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 更新指定数据
     *
     * @param entity
     * @throws Exception
     */
    @Override
    @Transactional
    @Modifying
    public void update(UserEntity entity) throws Exception {
        try{
            System.out.println(entity.getRealname());
            UserEntity entity1=userDao.findById(entity.getUserid()).get();
            entity1.setRealname(entity.getRealname());
            System.out.println(entity1.getRealname());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
