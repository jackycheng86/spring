package com.spring.service;

import com.spring.entity.FileEntity;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StorageService {

    /**
     * 获取所有文件列表
     * @return
     */
    List<FileEntity> findAll();

    /**
     * 加载指定的文件
     * @param fileId
     * @param fileName
     * @return
     */
    Resource loadAsResource(String fileId, String fileName);

    /**
     * 保存文件
     * @param file
     */
    void store(MultipartFile file);
}
