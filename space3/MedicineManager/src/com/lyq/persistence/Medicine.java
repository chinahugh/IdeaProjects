package com.lyq.persistence;

import java.util.Date;

/**
 * ҩƷ�־û���
 *
 * @author Li Yong Qiang
 */
public class Medicine {
    private int id;                    //id��
    private String name;            //ҩƷ����
    private String medNo;            //ҩƷ����
    private String factoryAdd;        //������ַ
    private String description;        //����
    private double price;            //�۸�
    private int medCount;            //����
    private int reqCount;            //��������
    private String photoPath;        //ͼƬ
    private Date editTime;            //ʱ��
    private Category category;        //���

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

    public String getMedNo() {
        return medNo;
    }

    public void setMedNo(String medNo) {
        this.medNo = medNo;
    }

    public String getFactoryAdd() {
        return factoryAdd;
    }

    public void setFactoryAdd(String factoryAdd) {
        this.factoryAdd = factoryAdd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMedCount() {
        return medCount;
    }

    public void setMedCount(int medCount) {
        this.medCount = medCount;
    }

    public int getReqCount() {
        return reqCount;
    }

    public void setReqCount(int reqCount) {
        this.reqCount = reqCount;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Date getEditTime() {
        return editTime;
    }

    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
