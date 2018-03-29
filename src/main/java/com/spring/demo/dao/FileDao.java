package com.spring.demo.dao;

import com.spring.common.dao.MyBaseRepository;
import com.spring.demo.entity.FileEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ com.spring.dao
 * @author cj
 * 2017/12/23
 **/
@Repository
public interface FileDao extends MyBaseRepository<FileEntity,String>{

    /**
     * 只查询文件名、文件id、文件类型不加载具体的文件内容
     * @return
     */
    @Query("select new FileEntity (f.fileid,f.filename,f.filetype,f.fileext)from FileEntity f")
    List<FileEntity> findAllFile();
}
