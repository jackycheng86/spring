package com.spring.service;

import com.spring.common.service.BaseServiceImpl;
import com.spring.dao.FileDao;
import com.spring.entity.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.spring.service
 *
 * @author jacky
 * @date 2017/12/23
 **/
@Service
@Transactional(readOnly = true)
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