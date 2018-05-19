package com.wssc.entity;

import com.wssc.dao.UserDao;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: hugh
 * @Time: 2017/12/30 5:00 PM
 * @Discraption:
 */
public class User implements Serializable {
    private static final long serialVersionUID = 560441188391483633L;
    private static final String FORMAT = "yyyy-MM-dd hh:MM:ss";
    private SimpleDateFormat format = new SimpleDateFormat(FORMAT);
    private int id;
    private String userName;
    private String userPassword;
    private Date openDate;
    private String phone;
    private String adress;

    public User() {
    }

    public User(String userName, String userPassword, Date openDate, String phone, String adress) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.openDate = openDate;
        this.phone = phone;
        this.adress = adress;
    }

    public User( int id, String userName, String userPassword, Date openDate, String phone, String adress) {
         this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.openDate = openDate;
        this.phone = phone;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getOpenDate() {
        return format.format(openDate);
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", openDate=" + getOpenDate() +
                ", phone='" + phone + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
