package com.wssc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: hugh
 * @Time: 2017/12/30 5:15 PM
 * @Discraption:
 */
public class Dd implements Serializable {
    private static final long serialVersionUID = -2006937005138653365L;

    private int id;
    private int userID;
    private String shdz;
    private Date xdsj;
    private int ddzt;
    private String bz;

    public Dd(int userID, String shdz, Date xdsj, int ddzt, String bz) {
        this.userID = userID;
        this.shdz = shdz;
        this.xdsj = xdsj;
        this.ddzt = ddzt;
        this.bz = bz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getShdz() {
        return shdz;
    }

    public void setShdz(String shdz) {
        this.shdz = shdz;
    }

    public Date getXdsj() {
        return xdsj;
    }

    public void setXdsj(Date xdsj) {
        this.xdsj = xdsj;
    }

    public int getDdzt() {
        return ddzt;
    }

    public void setDdzt(int ddzt) {
        this.ddzt = ddzt;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
