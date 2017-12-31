package com.spring;

import com.github.javafaker.Faker;
import com.spring.entity.FileEntity;
import com.spring.entity.UserEntity;
import com.spring.service.StorageService;
import com.spring.service.UserService;
import com.spring.util.CommonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private StorageService storageService;

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

    @Test
    public void fileTest(){
        List<FileEntity> files = storageService.findAll();
        if (files != null && files.size() > 0) {
            System.out.println(files.size());
            System.out.println(files.get(0).getFilename());
            files.forEach((file) -> System.out.println(file.getFilename()));
        }
    }

    @Test
    public void lambdaTest(){
        Faker faker=new Faker(new Locale("zh-CN"));
        List<FileEntity> files = new ArrayList<>();
        for(int i=0;i<5;i++){
            FileEntity f1=new FileEntity();
            f1.setFileid(CommonUtil.getUuid());
            f1.setFilename(faker.file().fileName());
            files.add(f1);
        }

        files.forEach(n -> System.out.println(n.getFilename()));
    }
}
