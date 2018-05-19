package com.demo.service;

import com.demo.dao.ProductMapper;
import com.demo.model.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/4/11
 * @Description ProductListService
 */
@Service
public class ProductListService  {
    @Resource
    private ProductMapper dao;


    /**
     * 按id查找
     *
     * @param id
     * @return
     */
    public Product findById(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    /**
     * 按id删除
     *  @param id
     */
    public void delete(Integer id) {

    }

    public List<Product> selectAll(){
        return dao.selectAll();
    }
}
