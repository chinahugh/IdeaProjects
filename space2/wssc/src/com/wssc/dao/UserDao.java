package com.wssc.dao;


import com.wssc.entity.User;
import com.wssc.util.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Author: hugh
 * @Time: 2017/12/30 4:58 PM
 * @Discraption:
 */
public class UserDao implements Dao<User> {
    /**
     *  增加一个User
     * @param user
     * @return boolean
     */
    @Override
    public boolean add(User user) {
        StringBuffer sql = new StringBuffer("insert into userinfo(username,userpassword,opendate,phone,adress) values('");
        sql.append(user.getUserName()).append("','")
                .append(user.getUserPassword()).append("','")
                .append(user.getOpenDate()).append("','")
                .append(user.getPhone()).append("','")
                .append(user.getAdress()).append("')");
        int i = JDBCUtils.executeUpdate(sql.toString());
        JDBCUtils.close();
        return i == 1;
    }

    /**
     *  删除一个User
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        String sql = "delete from  userinfo where id=" + id;
        int i = JDBCUtils.executeUpdate(sql);
        JDBCUtils.close();
        return i == 1;
    }

    /**
     *
     * @return List<User>
     */
    @Override
    public List<User> select() {
        String sql = "select * from userinfo";
        ResultSet resultSet = JDBCUtils.executeQuery(sql);
        List<User> users = new ArrayList<>(50);
        try {
            while (resultSet.next()) {
                User user = getBean(resultSet);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close();
        }
        return users;
    }

    public static void main(String[] args) {

        UserDao dao = new UserDao();
       /* System.out.println(dao.add(new User("root","root",new Date(),"1880949","ls")));*/
       /* System.out.println(dao.delete(2));*/
        /*dao.select().forEach(System.out::println);*/
      /*  System.out.println(dao.findOne(4));*/
        System.out.println(dao.update(new User(4, "root", "123", new Date(), "1880949", "ls")));
    }

    /**
     * @param rs
     * @return User
     */
    @Override
    public User getBean(ResultSet rs) {
        try {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String userpassword = rs.getString("userpassword");
            Date opendate = rs.getDate("opendate");
            String phone = rs.getString("phone");
            String adress = rs.getString("adress");

            return new User(2, username, userpassword, opendate, phone, adress);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close();
        }
        return null;
    }

    /**
     *  查找一个User
     * @param id
     * @return
     */
    @Override
    public User findOne(int id) {
        String sql = "select * from userinfo where id=" + id;
        ResultSet resultSet;
        try {
            resultSet = JDBCUtils.executeQuery(sql);
            resultSet.next();
            return getBean(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close();
        }
        return null;
    }

    /**
     *  更新一个User
     * @param user
     * @return
     */
    @Override
    public boolean update(User user) {
        StringBuffer sql = new StringBuffer("update  userinfo set username='");
        sql.append(user.getUserName()).append("',userpassword='");
        sql.append(user.getUserPassword()).append("',opendate='");
        sql.append(user.getOpenDate()).append("', phone='");
        sql.append(user.getPhone()).append("', adress='");
        sql.append(user.getAdress()).append("'");
        sql.append("where id=").append(user.getId());
        System.out.println(sql.toString());
        int i = JDBCUtils.executeUpdate(sql.toString());
        JDBCUtils.close();
        return 1 == i;
    }
}
