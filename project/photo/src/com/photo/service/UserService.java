package com.photo.service;

import com.photo.model.User;
import com.photo.util.DBUtil;

import java.util.ArrayList;

/**
 * @Auther HUGH
 * @Date 2018/3/18
 * @Description UserService 用户服务类
 */
public class UserService {

    /**
     * 通过用户名获取用户
     * @param username
     * @return
     */
    public User getUserByUsername(String username){
        String sql="select id,username,password from user where username=?";
        String[] parameters={username};
        ArrayList<Object[]> query = DBUtil.query(sql, parameters);
        if (query.size()==0){
            return null;
        }else {
            Object[] objects=query.get(0);
            return objects == null ? null : new User(Integer.parseInt(objects[0].toString()),objects[1].toString(),objects[2].toString(),null);
        }
    }

    public  void addUser(User user){
        String[] sqls={"insert into user(username,password) values(?,?)"};
        String[][] parameters={{user.getUsername(),user.getPassword()}};
        DBUtil.updates(sqls,parameters);
    }
}
