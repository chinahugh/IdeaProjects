package com.wll.pro.dao;

import com.wll.pro.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/5/29
 * @Description UserDao
 */
@Component
public interface UserDao extends BaseDao<User> {
    List<User> list(User t);
}
