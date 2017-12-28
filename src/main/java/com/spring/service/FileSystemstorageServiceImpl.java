package com.spring.service;

import org.springframework.stereotype.Component;

import java.nio.file.Path;

/**
 * com.spring.service
 * @author jacky
 * 2017/12/23
 **/
@Component
public class FileSystemstorageServiceImpl implements FileSystemStorageService{
    @Override
    public void init() {

    }


    @Override
    public Path load(String filename) {
        return null;
    }
}
