package com.lyq.persistence;

import java.util.Date;

/**
 * �û��־û���
 *
 * @author Li Yong Qiang
 */
public class User {
    private int id;                //id��
    private String username;    //�û���
    private String password;    //����
    private Date createTime;    //��������

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
