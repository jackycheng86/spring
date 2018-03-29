package com.spring.demo.service1;

import com.spring.common.service.BaseService;
import com.spring.demo.entity1.FileEntity;

import java.util.List;

/**
 * com.spring.service
 * @author jacky
 * @date 2017/12/23
 **/
public interface FileService1 extends BaseService<FileEntity, String> {

    /**
     * 查询所有文件
     * @return
     */
    List<FileEntity> findAllFile();
}
