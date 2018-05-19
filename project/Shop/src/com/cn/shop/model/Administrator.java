package com.cn.shop.model;


/**
 * 管理员用户
 *
 * @author hugh
 */
public class Administrator extends User {

    private String workNo; //工号

    public String getWorkNo() {
        return workNo;
    }

    public void setWorkNo(String workNo) {
        this.workNo = workNo;
    }
}
