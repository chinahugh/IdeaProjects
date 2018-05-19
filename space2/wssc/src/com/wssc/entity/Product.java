package com.wssc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: hugh
 * @Time: 2017/12/30 5:00 PM
 * @Discraption: 产品
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -6417172127722121510L;
    private int id;
    private String name;
    private String ms;
    private String scj;//市场价
    private String hyj;//会员价
    private Date sgrq;//上柜日期
    private int flID;//分类ID

    public Product(String name, String ms, String scj, String hyj, Date sgrq, int flID) {
        this.name = name;
        this.ms = ms;
        this.scj = scj;
        this.hyj = hyj;
        this.sgrq = sgrq;
        this.flID = flID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public String getScj() {
        return scj;
    }

    public void setScj(String scj) {
        this.scj = scj;
    }

    public String getHyj() {
        return hyj;
    }

    public void setHyj(String hyj) {
        this.hyj = hyj;
    }

    public Date getSgrq() {
        return sgrq;
    }

    public void setSgrq(Date sgrq) {
        this.sgrq = sgrq;
    }

    public int getFlID() {
        return flID;
    }

    public void setFlID(int flID) {
        this.flID = flID;
    }
}
