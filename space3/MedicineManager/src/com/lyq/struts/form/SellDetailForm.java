package com.lyq.struts.form;

import org.apache.struts.action.ActionForm;

import java.util.Date;

/**
 * ������ϢFromBean
 *
 * @author Li Yong Qiang
 */
public class SellDetailForm extends ActionForm {
    private static final long serialVersionUID = 1L;
    private int id;            // ���
    private String sellName;    // ����
    private double sellPrice;    // ����
    private int sellCount;        // ����
    private String factoryAdd;    // ����
    private double total;        // �ܶ�
    private Date SellTime;        // ����
    private int medId;            // ҩƷid

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFactoryAdd() {
        return factoryAdd;
    }

    public void setFactoryAdd(String factoryAdd) {
        this.factoryAdd = factoryAdd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSellName() {
        return sellName;
    }

    public void setSellName(String sellName) {
        this.sellName = sellName;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getSellCount() {
        return sellCount;
    }

    public void setSellCount(int sellCount) {
        this.sellCount = sellCount;
    }

    public Date getSellTime() {
        return SellTime;
    }

    public void setSellTime(Date sellTime) {
        SellTime = sellTime;
    }

    public int getMedId() {
        return medId;
    }

    public void setMedId(int medId) {
        this.medId = medId;
    }
}
