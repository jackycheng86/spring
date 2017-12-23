package com.spring.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T,ID extends Serializable> {
    /**
     * 不含查询条件的分页查询
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page<T> findAll(int pageNo, int pageSize) throws Exception;

    /**
     * 不含查询条件的分页查询
     * @param pageable
     * @return
     * @throws Exception
     */
    public Page<T> findAll(Pageable pageable) throws Exception;


    /**
     * 获取所有数据
     *
     * @return
     */
    public List<T> findAll() throws Exception;

    /**
     * 根据ID获取数据
     * @param va1
     * @return
     * @throws Exception
     */
    public T findOne(ID va1) throws Exception;

    /**
     * 新增指定数据
     * @param entity
     * @throws Exception
     */
    public void save(T entity) throws Exception;

    /**
     * 更新指定数据
     * @param entity
     * @throws Exception
     */
    public void update(T entity) throws Exception;

    /**
     * 删除指定数据
     * @param va1
     * @throws Exception
     */
    public void delete(ID va1) throws Exception;

    /**
     * 删除指定数据
     * @param entity
     * @throws Exception
     */
    public void delete(T entity) throws Exception;
}
