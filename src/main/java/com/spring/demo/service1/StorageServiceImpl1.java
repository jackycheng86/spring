package com.spring.demo.service1;

import com.spring.demo.entity1.FileEntity;
import com.spring.exception.GenericException;
import com.spring.exception.ItemNotFoundException;
import com.spring.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author jackycheng
 * @date 2017-12-29-下午3:54
 *
 * 作为文件处理的抽象实现供Controller调用
 *
 */

@Component
public class StorageServiceImpl1 implements StorageService1 {

    private FileSystemStorageService1 fileSystemStorageService;

    private FileService1 fileService;

    @Autowired
    public StorageServiceImpl1(FileSystemStorageService1 fileSystemStorageService, FileService1 fileService) {
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
    public Resource loadAsResource(String fileId, String fileName) {
        String[] fileProperties = fileName.split("\\.");
        String fileext = fileProperties[1];
        try {
            Path file = fileSystemStorageService.load(fileId + "." + fileext);
            Resource resource = null;
            if (Files.exists(file)) {
                resource = new UrlResource(file.toUri());
                return resource;
            } else {
                FileEntity fileEntity = fileService.findOne(fileId);
                if (fileEntity != null) {
                    resource = new ByteArrayResource(fileEntity.getFiledata());
                    fileSystemStorageService.store(fileEntity);
                    return resource;
                } else {
                    throw new ItemNotFoundException("数据库未找到该文件，文件编号为：" + fileId);
                }
            }
        } catch (Exception e) {
            throw new GenericException("获取指定文件失败！", e.getCause());
        }
    }

    /**
     * 加载指定文件
     *
     * @param fileName
     * @return
     */
    @Override
    public Resource loadResource(String fileName) {
        Path file = fileSystemStorageService.load(fileName);
        try {
            return new UrlResource(file.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 保存文件
     *
     * @param file
     */
    @Override
    public void store(MultipartFile file) {
        FileEntity fileEntity = new FileEntity();
        fileEntity.setFileid(CommonUtil.getUuid());
        fileEntity.setFiletype(file.getContentType());
        String[] fileProperties = file.getOriginalFilename().split("\\.");
        fileEntity.setFileext(fileProperties[1]);
        fileEntity.setFilename(fileProperties[0]);
        try {
            fileEntity.setFiledata(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileService.save(fileEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
