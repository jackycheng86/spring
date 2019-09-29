package com.spring.filter;

import com.spring.book.BookService;

import javax.servlet.*;
import java.io.IOException;

public class DemoBeanFilter implements Filter {

    private BookService bookService;

    public DemoBeanFilter(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("处理demoBeanFilter业务！");
        System.out.println("该filter需要其他bean完成业务！");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("demoBeanFilter初始化时执行！");
    }

    @Override
    public void destroy() {
        System.out.println("demoBeanFilter销毁时执行！");
    }
}
