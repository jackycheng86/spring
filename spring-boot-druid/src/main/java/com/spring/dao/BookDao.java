package com.spring.dao;

import com.spring.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<BookEntity,String> {
}
