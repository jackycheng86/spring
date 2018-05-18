package com.spring.javatest.io;

import com.github.javafaker.Faker;
import com.spring.config.SpringConfig;
import com.spring.javatest.entity.UserEntity;
import com.spring.util.CommonUtil;
import com.spring.util.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Locale;

/**
 * @author chengjian
 * @date 2018/5/15
 *
 * 针对对象序列化操作
 *
 **/
@Component
public class ObjectInputOutputTest {
    @Autowired
    private SpringBeanFactory springBeanFactory;


    /**
     * 将实体对象序列化后写入文件
     * 这时候文件中存入的并非字符串
     * 而是对象序列化后的内容
     * 因此通过文件编辑器打开会显示乱码内容
     * 只能通过java的反序列化操作读取文件中的内容
     */
    public void fileOutPutSerializable() {

        try {
            Faker faker=new Faker(new Locale("zh-CN"));
            UserEntity user=new UserEntity();
            user.setUserid(CommonUtil.getUuid());
            user.setUserpwd("123456");
            user.setUsername("a001");
            user.setRealname(faker.name().fullName());
            String fileName = springBeanFactory.getBean(SpringConfig.class).getLocation() + "output";
            FileOutputStream f = new FileOutputStream(fileName);
            ObjectOutput s = new ObjectOutputStream(f);
            s.writeObject(user);
            s.flush();
            s.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
