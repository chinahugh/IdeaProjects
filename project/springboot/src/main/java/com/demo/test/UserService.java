package com.demo.test;

import com.github.pagehelper.PageInfo;

/**
 * @Auther HUGH
 * @Date 2018/5/27
 * @Description UserService
 */
public interface UserService {

    int addUser(UserDomain user);

    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);
}
