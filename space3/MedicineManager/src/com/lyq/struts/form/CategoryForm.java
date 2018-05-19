package com.lyq.struts.form;

import org.apache.struts.action.ActionForm;

import java.util.Date;

/**
 * ���FormBean
 *
 * @author Li Yong Qiang
 */
public class CategoryForm extends ActionForm {
    private static final long serialVersionUID = 1L;    //���л�
    private int id;                //�����
    private String name;        //�������
    private String description;    //�������
    private Date createTime;    //��𴴽�ʱ��

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
