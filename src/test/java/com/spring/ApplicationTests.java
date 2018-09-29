package com.spring;

import com.github.javafaker.Faker;
import com.spring.demo.entity.FileEntity;
import com.spring.demo.entity.UserEntity;
import com.spring.demo.service.FileSystemStorageService;
import com.spring.demo.service.StorageService;
import com.spring.demo.service.UserService;
import com.spring.demo.service1.UserService1;
import com.spring.javatest.io.ObjectInputOutputTest;
import com.spring.javatest.io.TextInputOutputTest;
import com.spring.redis.RedisCommonUtil;
import com.spring.util.CommonUtil;
import com.spring.util.XmlUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private UserService1 userService1;
    @Autowired
    private StorageService storageService;
    @Autowired
    private FileSystemStorageService fileSystemStorageService;
    @Autowired
    private ObjectInputOutputTest outPutStreamTest;
    @Autowired
    private TextInputOutputTest textInputOutputTest;
    @Autowired
    private RedisCommonUtil<String> redisCommonUtil;
    @Autowired
    private RedisCommonUtil<UserEntity> redisCommonUtil1;

    @Test
    public void contextLoads() {
    }

    @Test
    public void userTest() {
        Faker faker = new Faker(new Locale("zh-CN"));
        UserEntity user = new UserEntity();
        user.setUserid(CommonUtil.getUuid());
        user.setUserpwd("123456");
        user.setUsername("a001");
        user.setRealname(faker.name().fullName());
        com.spring.demo.entity1.UserEntity entity1 = new com.spring.demo.entity1.UserEntity();
        BeanUtils.copyProperties(user, entity1);
        try {
            userService.save(user);
            userService1.save(entity1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void userTest1() {
        Faker faker = new Faker(new Locale("zh-CN"));
        UserEntity user = new UserEntity();
        user.setUserid(CommonUtil.getUuid());
        user.setUserpwd("123456");
        user.setUsername("a001");
        user.setRealname(faker.name().fullName());
    }

    @Test
    public void fileTest() {
        fileSystemStorageService.init();
//        List<FileEntity> files = storageService.findAll();
//        if (files != null && files.size() > 0) {
//            System.out.println(files.size());
//            System.out.println(files.get(0).getFilename());
//            files.forEach((file) -> System.out.println(file.getFilename()));
//        }
    }

    @Test
    public void lambdaTest() {
        Faker faker = new Faker(new Locale("zh-CN"));
        List<FileEntity> files = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            FileEntity f1 = new FileEntity();
            f1.setFileid(CommonUtil.getUuid());
            f1.setFilename(faker.file().fileName());
            files.add(f1);
        }

        files.forEach(n -> System.out.println(n.getFilename()));
    }

    @Test
    public void xmlTest() {
        Faker faker = new Faker(new Locale("zh-CN"));
        //创建实体对象
        UserEntity user = new UserEntity();
        user.setUserid(CommonUtil.getUuid());
        user.setUsername("a001");
        user.setRealname(faker.name().fullName());
        //将实体对象转换为xml字符串
        String xmlString = XmlUtil.toXmlString(user, UserEntity.class);
        System.out.println(xmlString);
        //创建文件实体
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileid(user.getUsername());
        fileEntity.setFileext("xml");
        fileEntity.setFilename(user.getUsername());
        fileEntity.setFiledata(xmlString.getBytes());
        //将xml字符串保存到相应的xml文件中
        fileSystemStorageService.store(fileEntity);
        try {
            //测试从xml文件中读取xml字符串
            String fileContent = new String(Files.readAllBytes(fileSystemStorageService.load("a001.xml")));
            System.out.println("read from file");
            System.out.println(fileContent);
            //将读取到的xml字符串转化成实体
            UserEntity usser1 = (UserEntity) XmlUtil.toObject(fileContent, UserEntity.class);
            System.out.println(usser1.getUsername());
            System.out.println(usser1.getRealname());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void javaTestOutPutStream() {
        //outPutStreamTest.fileOutPutSerializable();
        //textInputOutputTest.bufferedOutputStream("");
        textInputOutputTest.bufferedWriter("bufferedWriter测试");
    }

    @Test
    public void stringRedisTest() {
        String key = "key1";
        String value = "key1_value";
        redisCommonUtil.setCache(key, value);
        String value1 = redisCommonUtil.getCache(key);
        System.out.println(value1);
    }

    @Test
    public void objectRedisTest() {
        UserEntity user = new UserEntity();
        user.setUserid("a01");
        user.setUserpwd("123456");
        user.setUsername("a001");
        user.setRealname("测试名称");
        redisCommonUtil1.setHashCache(UserEntity.USERENTITY_KEY, user.getUserid(), user);
        Object user1=redisCommonUtil1.getHashCache(UserEntity.USERENTITY_KEY,user.getUserid());
        if(user1!=null){
            UserEntity user2=(UserEntity) user1;
            System.out.println(user2.getUserid());
            System.out.println(user2.getUserpwd());
            System.out.println(user2.getUsername());
            System.out.println(user2.getRealname());
        }
    }

}
