package com.spring.common.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by jacky on 16-8-26.
 */
@NoRepositoryBean
public interface MyBaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
