package com.spring.service;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * com.spring.service
 * cj
 * 2017/12/23
 **/
public interface FileSystemStorageService {
    void init();

    Stream<Path> loadAll();

    Path load(String filename);
}
