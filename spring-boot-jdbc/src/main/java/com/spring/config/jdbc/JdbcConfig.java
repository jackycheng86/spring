package com.spring.config.jdbc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    @Bean
    public JdbcTemplate jdbcTemplate(
            @Qualifier("druidDataSource") DataSource druidDataSource) {
        return new JdbcTemplate(druidDataSource);
    }
}
