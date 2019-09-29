package com.spring.quartz.schedule.methodinovke;

import com.spring.quartz.book.entity.Book;
import com.spring.quartz.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MethodJob2 {

    private BookService bookService;

    @Autowired
    public MethodJob2(BookService bookService) {
        this.bookService = bookService;
    }

    public void doJob(){
        try {
            System.out.println("------------------任务开始MethodJob2------------------");
            Book book = bookService.get();
            System.out.println(book.toString());
            System.out.println("------------------任务结束MethodJob2------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
