package com.demo.test.dao;

import com.demo.test.UserDomain;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/5/27
 * @Description UserDao
 */
public interface UserDao {


    int insert(UserDomain record);



    List<UserDomain> selectUsers();
}
