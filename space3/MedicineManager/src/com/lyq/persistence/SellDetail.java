package com.lyq.persistence;

import java.util.Date;

/**
 * ������ϸ�־û���
 *
 * @author Li Yong Qiang
 */
public class SellDetail {
    private int id;                //���
    private String sellName;    //ҩƷ����
    private double sellPrice;    //�۸�
    private int sellCount;        //����
    private Date sellTime;        //ʱ��
    private Medicine med;        //ҩƷ
    private User user;            //������Ա
    private double sellTotal;    //�ܶ�(�Զ�����û��set����)

    public double getSellTotal() {
        //�����ܶ�
        if (this.sellCount > 0 && this.sellPrice > 0) {
            this.sellTotal = this.sellPrice * this.sellCount;
        }
        return sellTotal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSellName() {
        return sellName;
    }

    public void setSellName(String sellName) {
        this.sellName = sellName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
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

    public Medicine getMed() {
        return med;
    }

    public void setMed(Medicine med) {
        this.med = med;
    }
}
