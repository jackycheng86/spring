package com.spring.quartz.book.service.impl;

import com.spring.quartz.book.entity.Book;
import com.spring.quartz.book.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public Book add() {
        Book book = new Book();
        book.setId("001");
        book.setName("软件工程");
        book.setAuthor("test");
        return book;
    }

    @Override
    public Book get() {
        Book book = new Book();
        book.setId("002");
        book.setName("计算机科学与技术");
        book.setAuthor("test");
        return book;
    }
}
