package com.spring.demo.service;

import com.spring.config.SpringConfig;
import com.spring.demo.entity.FileEntity;
import com.spring.exception.GenericException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * com.spring.service
 *
 * @author jacky
 * @date 2017/12/23
 *
 * 与磁盘交互实现磁盘上的文件读写
 *
 **/
@Component
public class FileSystemstorageServiceImpl implements FileSystemStorageService {

    private final Path rootLocation;

    @Autowired
    public FileSystemstorageServiceImpl(SpringConfig config) {
        this.rootLocation = Paths.get(config.getLocation());
    }

    /**
     * 初始化存储路径
     */
    @Override
    public void init() {
        try {
            //判断文件夹是否存在，不存在则创建文件夹
            if (!Files.isDirectory(rootLocation)) {
                Files.createDirectories(rootLocation);
            }
        } catch (Exception e) {
            throw new GenericException("不能初始化存储位置", e);
        }
    }

    /**
     * 从磁盘加载指定文件
     *
     * @param filename
     * @return
     */
    @Override
    public Path load(String filename) {
        this.init();
        return rootLocation.resolve(filename);
    }

    /**
     * 将文件缓存到磁盘
     *
     * @param fileEntity
     */
    @Override
    public void store(FileEntity fileEntity) {
        try {
            String fileName = fileEntity.getFileid() + "." + fileEntity.getFileext();
            if (fileEntity.getInputStream() != null) {
                //利用nio将文件从二进制流写入磁盘文件中
                Files.copy(fileEntity.getInputStream(), rootLocation.resolve(fileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
