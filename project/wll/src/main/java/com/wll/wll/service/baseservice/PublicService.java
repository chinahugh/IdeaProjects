package com.wll.wll.service.baseservice;

import com.wll.wll.dao.basedao.PublicDao;
import com.wll.wll.entity.baseentity.BaseEntity;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/5/16
 * @Description PublicService
 */
public class PublicService <D extends PublicDao<T>,T extends BaseEntity<T>> extends BaseService{
    protected D dao;

    public int get(String id) {
        return dao.get(id);
    }

    public int insert(T record) {
        return dao.insert(record);
    }

    public int insertSelective(T record) {
        return dao.insertSelective(record);
    }

    public T selectByPrimaryKey(String id) {
        return dao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(T record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(T record) {
        return dao.updateByPrimaryKey(record);
    }

    public List<T> list(T record) {
        return dao.list(record);
    }
}
