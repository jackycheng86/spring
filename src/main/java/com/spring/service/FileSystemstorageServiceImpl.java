package com.spring.service;

import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * com.spring.service
 * cj
 * 2017/12/23
 **/
@Component
public class FileSystemstorageServiceImpl implements FileSystemStorageService{
    @Override
    public void init() {

    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }
}
