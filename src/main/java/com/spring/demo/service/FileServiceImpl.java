package com.spring.demo.service;

import com.spring.common.service.BaseServiceImpl;
import com.spring.demo.dao.FileDao;
import com.spring.demo.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.spring.service
 *
 * @author jacky
 * @date 2017/12/23
 *
 * 与数据库交互实现数据库层面的文件读写
 *
 **/
@Service
@Transactional(readOnly = true,transactionManager = "transactionManager")
public class FileServiceImpl extends BaseServiceImpl<FileEntity, String> implements FileService {
    private FileDao fileDao;

    @Autowired
    public FileServiceImpl(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    /**
     * 查询所有文件
     *
     * @return
     */
    @Override
    public List<FileEntity> findAllFile() {
        return fileDao.findAllFile();
    }
}
