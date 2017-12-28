package com.spring.service;

import java.nio.file.Path;

/**
 * com.spring.service
 * @author jacky
 * 2017/12/23
 **/
public interface FileSystemStorageService {

    /**
     * 初始化存储路径
     */
    public void init();

    /**
     * 加载指定文件
     * @param filename
     * @return
     */
    public Path load(String filename);
}
