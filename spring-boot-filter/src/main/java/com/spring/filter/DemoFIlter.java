package com.spring.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "demoFilter",urlPatterns = "/filter/demo/*")
public class DemoFIlter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("处理demoFilter业务！");
        System.out.println("该filter不需要其他bean完成业务！");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("demoFilter初始化时执行！");
    }

    @Override
    public void destroy() {
        System.out.println("demoFilter销毁时执行！");
    }
}
