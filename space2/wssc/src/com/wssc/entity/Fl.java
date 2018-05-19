package com.wssc.entity;

import java.io.Serializable;

/**
 * @Author: hugh
 * @Time: 2017/12/30 5:20 PM
 * @Discraption: 分类
 */
public class Fl implements Serializable{
    private static final long serialVersionUID = 8030662494422602086L;

    private int id;
    private String flm;
    private String ms;
    private int cjs;
    private String wz;

    public Fl(String flm, String ms, int cjs, String wz) {
        this.flm = flm;
        this.ms = ms;
        this.cjs = cjs;
        this.wz = wz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlm() {
        return flm;
    }

    public void setFlm(String flm) {
        this.flm = flm;
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms;
    }

    public int getCjs() {
        return cjs;
    }

    public void setCjs(int cjs) {
        this.cjs = cjs;
    }

    public String getWz() {
        return wz;
    }

    public void setWz(String wz) {
        this.wz = wz;
    }
}
