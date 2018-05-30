package com.spring.javatest.io;

import com.google.common.base.Strings;
import com.spring.config.SpringConfig;
import com.spring.util.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @author chengjian
 * @date 2018/5/16
 *
 * 针对文本内容操作
 *
 **/
@Component
public class TextInputOutputTest {
    @Autowired
    private SpringBeanFactory springBeanFactory;
    private final String str="默认测试字符串";

    /**
     * 使用BufferedOutputStream输出文本到文件
     */
    public void bufferedOutputStream(String str){
        String fileName = springBeanFactory.getBean(SpringConfig.class).getLocation() + "bufferedOutputStream";
        try {
            if(Strings.isNullOrEmpty(str)){
                str=this.str;
            }
            BufferedOutputStream buffer=new BufferedOutputStream(new FileOutputStream(fileName));
            buffer.write(str.getBytes());
            buffer.flush();
            buffer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用FileOutputStream将文本内容写入文件
     */
    public void fileOutputStream(String str){
        String fileName = springBeanFactory.getBean(SpringConfig.class).getLocation() + "fileOutputStream";
        try {
            if(Strings.isNullOrEmpty(str)){
                str=this.str;
            }
            FileOutputStream output=new FileOutputStream(fileName);
            output.write(str.getBytes());
            output.flush();
            output.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用BufferedWriter将文本写入文件
     * @param str
     */
    public void bufferedWriter(String str){
        String fileName=springBeanFactory.getBean(SpringConfig.class).getLocation()+"bufferedWriter";
        try {
            FileWriter fileWriter=new FileWriter(fileName);
            PrintWriter printWriter=new PrintWriter(new BufferedWriter(fileWriter));
            printWriter.print(str);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
