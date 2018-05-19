package com.demo.service;
import javax.annotation.Resource;

import com.demo.dao.UserMapper;
import com.demo.model.User;
import com.demo.service.service.IUserService;
import org.springframework.stereotype.Service;
/**
 * @Auther HUGH
 * @Date 2018/4/9
 * @Description UserServiceImpl
 */
@Service
public class UserServiceImpl{
    @Resource
    private UserMapper userDao;
    public User getUserById(int userId) {
        // TODO Auto-generated method stub
        return this.userDao.selectByPrimaryKey(userId);
    }

}