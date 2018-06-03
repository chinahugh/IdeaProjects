package com.wll.pro.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/5/29
 * @Description BaseDao
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T> {
    T get(String id);
    List<T> list(T t);
}
