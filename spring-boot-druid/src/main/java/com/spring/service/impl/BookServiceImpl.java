package com.spring.service.impl;

import com.spring.dao.BookDao;
import com.spring.entity.BookEntity;
import com.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {
    private BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    public void save(BookEntity bookEntity) throws Exception {
        bookDao.save(bookEntity);
    }

    @Override
    public void delete(String id) throws Exception {
        bookDao.deleteById(id);
    }

    @Override
    public List<BookEntity> findAll() throws Exception {
        return bookDao.findAll();
    }

    @Override
    public Page<BookEntity> findByPage(int pageNo, int pageSize) throws Exception {
        return bookDao.findAll(PageRequest.of(pageNo, pageSize));
    }
}
