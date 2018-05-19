package com.wssc.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 * @Author: hugh
 * @Time: 2017/12/30 5:28 PM
 * @Discraption:
 */
public interface Dao<T> {

    boolean add(T t);
    boolean delete(int id);
    List<T> select();
    T findOne(int id);
    boolean update(T t);
    T getBean(ResultSet re);
}
