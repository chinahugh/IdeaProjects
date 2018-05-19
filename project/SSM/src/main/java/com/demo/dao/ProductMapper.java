package com.demo.dao;


import com.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
@MyBatisDao
public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectAll();
}