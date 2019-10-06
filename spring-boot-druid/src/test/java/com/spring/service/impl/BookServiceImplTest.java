package com.spring.service.impl;

import com.spring.entity.BookEntity;
import com.spring.service.BookService;
import com.spring.util.UUIDUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;


    @Test
    public void save() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(UUIDUtil.getUUID32());
        bookEntity.setName("abc");
        bookEntity.setAuthor("abc");
        bookEntity.setIsbn(UUIDUtil.getUUID32());
        bookEntity.setPublish("abc");
        try {
            bookService.save(bookEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delete() {
    }

    @Test
    public void findAll() {
        try {
            List<BookEntity> list = bookService.findAll();
            System.out.println(list.size());
            for (BookEntity entity : list) {
                System.out.println(entity.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findByPage() {
    }
}