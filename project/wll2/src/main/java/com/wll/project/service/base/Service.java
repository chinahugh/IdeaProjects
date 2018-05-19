package com.wll.service.base;

import com.wll.mapper.base.BaseDao;

import javax.annotation.Resource;

/**
 * @Auther HUGH
 * @Date 2018/5/6
 * @Description ServiceImp
 */

public class Service<T extends BaseDao<D>, D> implements BaseDao<D> {
    @Resource
    T t;

    @Override
    public int deleteByPrimaryKey(String id) {
        return t.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(D record) {
        return t.insert(record);
    }

    @Override
    public int insertSelective(D record) {
        return 0;
    }

    @Override
    public D selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(D record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(D record) {
        return 0;
    }
}
