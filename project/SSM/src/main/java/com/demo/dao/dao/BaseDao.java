package com.demo.dao.dao;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/4/15
 * @Description BaseDao
 */
public interface BaseDao<T> {
    List<T> selectAll();
}
