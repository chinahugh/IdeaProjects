package com.wll.wll.dao.basedao;

import com.wll.wll.entity.baseentity.BaseEntity;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/5/16
 * @Description BaseDao
 */
public interface PublicDao<T> extends BaseDao  {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pro_main
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pro_main
     *
     * @mbg.generated
     */
    int insert(T record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pro_main
     *
     * @mbg.generated
     */
    int insertSelective(T record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pro_main
     *
     * @mbg.generated
     */
    T selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pro_main
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pro_main
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(T record);

    <T extends BaseEntity<T>> List<T> list(T record);
}