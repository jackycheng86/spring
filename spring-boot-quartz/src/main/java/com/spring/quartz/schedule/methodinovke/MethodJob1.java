package com.spring.quartz.schedule.methodinovke;

import com.spring.quartz.book.entity.Book;
import com.spring.quartz.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MethodJob1 {
    private BookService bookService;

    @Autowired
    public MethodJob1(BookService bookService) {
        this.bookService = bookService;
    }

    public void doJob(){
        try {
            System.out.println("------------------任务开始MethodJob1------------------");
            Book book = bookService.add();
            System.out.println(book.toString());
            System.out.println("------------------任务结束MethodJob1------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
