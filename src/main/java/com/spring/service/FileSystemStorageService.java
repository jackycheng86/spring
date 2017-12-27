package com.spring.service;

import java.nio.file.Path;
import java.util.List;

/**
 * com.spring.service
 * cj
 * 2017/12/23
 **/
public interface FileSystemStorageService {

    /**
     * 初始化
     */
    public void init();

    public List<Path> loadAll();

    public Path load(String filename);
}
