package com.spring.service;

import com.spring.common.service.BaseServiceImpl;
import com.spring.entity.FileEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.spring.service
 * cj
 * 2017/12/23
 **/
@Service
@Transactional(readOnly = true)
public class FileServiceImpl extends BaseServiceImpl<FileEntity, String> implements FileService {
}
