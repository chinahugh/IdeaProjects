package com.slx.zsxt.dao;

import com.slx.zsxt.model.Product;

/**
 * @Auther HUGH
 * @Date 2018/5/3
 * @Description pro
 */
public interface pro {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

}
