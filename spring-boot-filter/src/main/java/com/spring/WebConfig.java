package com.spring;

import com.spring.book.BookService;
import com.spring.filter.DemoBeanFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

@Configuration
public class WebConfig {

    @Bean
    public Filter demoBeanFilter(BookService bookService) {
        return new DemoBeanFilter(bookService);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(@Autowired BookService bookService) {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(demoBeanFilter(bookService));
        registrationBean.addUrlPatterns("/filter/bean/*");
        registrationBean.setName("demoBeanFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
