package com.spring.dao;

import com.spring.common.dao.MyBaseRepository;
import com.spring.entity.FileEntity;
import org.springframework.stereotype.Repository;

/**
 * com.spring.dao
 * cj
 * 2017/12/23
 **/
@Repository
public interface FileDao extends MyBaseRepository<FileEntity,String>{
}
