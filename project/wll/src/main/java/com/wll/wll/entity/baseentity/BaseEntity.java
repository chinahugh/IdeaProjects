package com.wll.wll.entity.baseentity;

import com.alibaba.druid.util.StringUtils;

import java.io.Serializable;

/**
 * @Auther HUGH
 * @Date 2018/5/16
 * @Description BaseEntity
 */
public class BaseEntity<T> implements Cloneable,Serializable {
    private String id;
    private Boolean isNewRecord=false;

    public BaseEntity() {
        super();
    }

    public BaseEntity(String id) {
        this();
        this.id = id;
    }

    @Override
    protected Object clone(){
        BaseEntity<T> entity=null;
        try {
            entity=(BaseEntity<T>)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return entity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getNewRecord() {
        return isNewRecord|| StringUtils.isEmpty(getId());
    }

    public void setNewRecord(Boolean isNewRecord) {
        this.isNewRecord = isNewRecord;
    }
}
