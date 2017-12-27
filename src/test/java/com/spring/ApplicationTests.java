package com.spring;

import com.github.javafaker.Faker;
import com.spring.entity.UserEntity;
import com.spring.service.UserService;
import com.spring.util.CommonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private UserService userService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void userTest(){
        Faker faker=new Faker(new Locale("zh-CN"));
        UserEntity user=new UserEntity();
        user.setUserid(CommonUtil.getUuid());
        user.setUsername("a001");
        user.setRealname(faker.name().fullName());
        try {
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
