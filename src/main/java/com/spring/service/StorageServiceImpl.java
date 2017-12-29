package com.spring.service;

import com.spring.entity.FileEntity;
import com.spring.exception.ItemSaveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

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
     * @param fileName
     * @return
     */
    @Override
    public Resource loadAsResource(String fileName) {

        return null;
    }

    /**
     * 保存文件
     *
     * @param fileEntity
     */
    @Override
    public void store(FileEntity fileEntity) {
        try {
            fileService.save(fileEntity);
        } catch (Exception e) {
            throw new ItemSaveException(fileEntity.getFilename()+"保存数据库失败！",e.getCause());
        }
    }
}
