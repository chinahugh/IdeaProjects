package com.demo.test.service;
import javax.annotation.Resource;

import com.demo.test.dao.UserMapper;
import com.demo.test.model.User;
import org.springframework.stereotype.Service;
/**
 * @Auther HUGH
 * @Date 2018/4/9
 * @Description UserServiceImpl
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userDao;
    @Override
    public User getUserById(int userId) {
        // TODO Auto-generated method stub
        return this.userDao.selectByPrimaryKey(userId);
    }

}