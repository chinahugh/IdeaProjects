package com.wll.pro.service;

import com.wll.pro.dao.UserDao;
import com.wll.pro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/5/29
 * @Description HelloService
 */
@Service
public class HelloService {
    @Resource
    private UserDao userDao;

    public User get(String id) {
        return userDao.get(id);
    }

    public List<User> list(User user) {
        return userDao.list(user);
    }
}
