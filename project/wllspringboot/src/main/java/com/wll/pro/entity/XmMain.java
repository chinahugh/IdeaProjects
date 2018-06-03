package com.wll.pro.entity;


import com.sun.istack.internal.NotNull;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @Auther HUGH
 * @Date 2018/5/31
 * @Description XmMain
 */
public class XmMain {
    @NotEmpty(message = "name 不能为空")
    private String name;
    private Date datetime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }
}
