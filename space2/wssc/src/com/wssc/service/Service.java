package com.wssc.service;

import java.util.List;

/**
 * @Author: hugh
 * @Time: 2017/12/31 7:46 PM
 * @Discraption:
 */
public interface Service<T> {
    boolean add(T t);
    boolean delete(int id);
    List<T> select();
    T findOne(int id);
    boolean update(T t);
}
