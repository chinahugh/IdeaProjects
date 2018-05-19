package com.demo.service.service;

import com.demo.model.User;
import org.springframework.stereotype.Service;

/**
 * @Auther HUGH
 * @Date 2018/4/9
 * @Description IUserService
 */

public interface IUserService {
    public User getUserById(int userId);
}
