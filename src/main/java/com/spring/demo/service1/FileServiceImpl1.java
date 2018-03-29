package com.spring.demo.service1;

import com.spring.common.service.BaseServiceImpl;
import com.spring.demo.dao1.FileDao1;
import com.spring.demo.entity1.FileEntity;
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
@Transactional(readOnly = true,transactionManager = "transactionManager1")
public class FileServiceImpl1 extends BaseServiceImpl<FileEntity, String> implements FileService1 {
    private FileDao1 fileDao;

    @Autowired
    public FileServiceImpl1(FileDao1 fileDao) {
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
