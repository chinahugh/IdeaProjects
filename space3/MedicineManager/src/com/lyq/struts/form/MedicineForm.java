package com.lyq.struts.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import java.util.Date;

/**
 * ҩƷFormBean
 *
 * @author Li Yong Qiang
 */
public class MedicineForm extends ActionForm {
    private static final long serialVersionUID = 1L;
    private int id;                //ҩƷid��
    private String medNo;        //ҩƷ����
    private String name;        //ҩƷ����
    private String factoryAdd;    //������ַ
    private String description;    //����
    private double price;        //�۸�
    private int medCount;        //�������
    private int reqCount;        //��������
    private FormFile photo;    //ͼƬ
    private String photoPath;    //ͼƬ·��
    private Date editDate;        //ʱ��
    private int categoryId;        //�������

    public int getReqCount() {
        return reqCount;
    }

    public void setReqCount(int reqCount) {
        this.reqCount = reqCount;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public String getMedNo() {
        return medNo;
    }

    public void setMedNo(String medNo) {
        this.medNo = medNo;
    }

    public int getMedCount() {
        return medCount;
    }

    public void setMedCount(int medCount) {
        this.medCount = medCount;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
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

    public FormFile getPhoto() {
        return photo;
    }

    public void setPhoto(FormFile photo) {
        this.photo = photo;
    }

}
