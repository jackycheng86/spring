package com.spring.service;

import com.spring.entity.BookEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {

    void save(BookEntity bookEntity) throws Exception;

    void delete(String id) throws Exception;

    List<BookEntity> findAll() throws Exception;

    Page<BookEntity> findByPage(int pageNo, int pageSize) throws Exception;
}
