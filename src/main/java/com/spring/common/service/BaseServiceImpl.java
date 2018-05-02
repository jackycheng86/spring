package com.spring.common.service;

import com.spring.common.dao.MyBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * com.hw.myp2c.common.service
 * jackycheng
 * 2017/11/22
 **/
public abstract class BaseServiceImpl<T,ID extends Serializable> implements BaseService<T,ID>{

    @Autowired
    private MyBaseRepository<T,ID> myBaseRepository;

    /**
     * 不含查询条件的分页查询
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Page<T> findAll(int pageNo, int pageSize) throws Exception {
        return myBaseRepository.findAll(new PageRequest(pageNo,pageSize));
    }

    /**
     * 不含查询条件的分页查询
     *
     * @param pageable
     * @return
     * @throws Exception
     */
    @Override
    public Page<T> findAll(Pageable pageable) throws Exception {
        return myBaseRepository.findAll(pageable);
    }

    /**
     * 获取所有数据
     *
     * @return
     */
    @Override
    public List<T> findAll() throws Exception {
        return myBaseRepository.findAll();
    }

    /**
     * 根据ID获取数据
     *
     * @param va1
     * @return
     * @throws Exception
     */
    @Override
    public T findOne(ID va1) throws Exception {
        return myBaseRepository.getOne(va1);
    }

    /**
     * 新增指定数据
     *
     * @param entity
     * @throws Exception
     */
    @Override
    public void save(T entity) throws Exception {
        myBaseRepository.save(entity);
    }

    /**
     * 更新指定数据
     *
     * @param entity
     * @throws Exception
     */
    @Override
    public void update(T entity) throws Exception {

    }

    /**
     * 删除指定数据
     *
     * @param va1
     * @throws Exception
     */
    @Override
    public void delete(ID va1) throws Exception {
        myBaseRepository.delete(findOne(va1));
    }


    /**
     * 删除指定数据
     * @param entity
     * @throws Exception
     */
    @Override
    public  void delete(T entity) throws Exception{
        myBaseRepository.delete(entity);
    }
}
