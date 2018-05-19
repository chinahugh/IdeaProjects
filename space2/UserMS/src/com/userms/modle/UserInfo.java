package com.userms.modle;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: hugh
 * @Time: 2017/12/27 9:41 PM
 * @Discraption:
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -5629751524309532579L;
    private Integer id;
    private String name;
    private String password;
    private Date openDate;

    public Integer getId() {
        DateFormat format = new SimpleDateFormat("yyymm");
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }
}
