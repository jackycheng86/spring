package com.spring.service;

import com.spring.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author jackycheng
 * @date 2017-12-29-下午3:54
 */

@Component
public class StorageServiceImpl  implements StorageService{

    private FileSystemStorageService fileSystemStorageService;

    private FileService fileService;

    @Autowired
    public StorageServiceImpl(FileSystemStorageService fileSystemStorageService, FileService fileService) {
        this.fileSystemStorageService = fileSystemStorageService;
        this.fileService = fileService;
    }

    /**
     * 获取所有文件列表
     *
     * @return
     */
    @Override
    public List<FileEntity> findAll() {
        return fileService.findAllFile();
    }

    /**
     * 加载指定的文件
     *
     * @param fileId
     * @param fileName
     * @return
     */
    @Override
    public Resource loadAsResource(String fileId,String fileName) {
        Resource file=fileSystemStorageService.load();
        return null;
    }

    /**
     * 保存文件
     *
     * @param file
     */
    @Override
    public void store(MultipartFile file) {

    }
}
