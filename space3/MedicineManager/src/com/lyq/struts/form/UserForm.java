package com.lyq.struts.form;

import org.apache.struts.action.ActionForm;

import java.util.Date;

/**
 * �û�FormBean
 *
 * @author Li Yong Qiang
 */
public class UserForm extends ActionForm {

    private static final long serialVersionUID = 1L;    //���л�
    private int id;                //id��
    private String username;    //�û���
    private String password;    //����
    private String oldPassword;    //ԭ���루�޸������ã�
    private String rePassword;    //ȷ������
    private Date createTime;    //����ʱ��


    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

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
