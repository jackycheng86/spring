package com.spring.book;

import org.springframework.stereotype.Component;

@Component
public class BookService {
    public void doFilter(){
        System.out.println("调用业务bean实现业务逻辑！");
    }
}
