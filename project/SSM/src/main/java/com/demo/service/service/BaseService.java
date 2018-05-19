package com.demo.service.service;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/4/11
 * @Description BaseService
 */
public interface BaseService<T> {
    /**
     * 查找全部
     * @return
     */
    List<T> findAll();

    /**
     * 按id查找
     * @param id
     * @return
     */
    T findById(Integer id);

    /**
     * 按id删除
     * @param id
     */
    void delete(Integer id);
}
