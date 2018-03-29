package com.spring.demo.service;

import com.spring.common.service.BaseService;
import com.spring.demo.entity.FileEntity;

import java.util.List;

/**
 * com.spring.service
 * @author jacky
 * @date 2017/12/23
 **/
public interface FileService extends BaseService<FileEntity, String> {

    /**
     * 查询所有文件
     * @return
     */
    List<FileEntity> findAllFile();
}
