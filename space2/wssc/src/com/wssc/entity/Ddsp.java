package com.wssc.entity;

import java.io.Serializable;

/**
 * @Author: hugh
 * @Time: 2017/12/30 5:17 PM
 * @Discraption:
 */
public class Ddsp implements Serializable{

    private static final long serialVersionUID = -4071055140318477794L;
    private int id;
    private int ddID;
    private String productID;
    private int spsl;
    private double dj;

    public Ddsp(int ddID, String productID, int spsl, double dj) {
        this.ddID = ddID;
        this.productID = productID;
        this.spsl = spsl;
        this.dj = dj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDdID() {
        return ddID;
    }

    public void setDdID(int ddID) {
        this.ddID = ddID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getSpsl() {
        return spsl;
    }

    public void setSpsl(int spsl) {
        this.spsl = spsl;
    }

    public double getDj() {
        return dj;
    }

    public void setDj(double dj) {
        this.dj = dj;
    }
}
