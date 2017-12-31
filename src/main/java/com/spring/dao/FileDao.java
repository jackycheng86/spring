package com.spring.dao;

import com.spring.common.dao.MyBaseRepository;
import com.spring.entity.FileEntity;
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

    @Query("select new FileEntity (f.fileid,f.filename,f.filetype,f.fileext)from FileEntity f")
    List<FileEntity> findAllFile();
}
