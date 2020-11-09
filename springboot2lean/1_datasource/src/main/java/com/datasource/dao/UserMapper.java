package com.datasource.dao;

import com.datasource.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author HGH
 */
@Mapper
public interface Test2Interface {

    @Select("select * from user where id=#{user.id}")
    User find(User user);
}
