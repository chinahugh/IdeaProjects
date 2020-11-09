package com.datasource.dao;

import com.datasource.entity.Testdatasource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author HGH
 */
@Mapper
public interface UserMapper {

    @Select("select id,name,insertime from testdatasource where id=#{id}")
    Testdatasource findById(@Param("id") Integer id);
}
