package com.wll.pro.dao;



import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/5/29
 * @Description BaseDao
 */
public interface BaseDao<T> {
    T get(String id);
    List<T> list(T t);
}
