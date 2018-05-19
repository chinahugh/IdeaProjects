package com.wll.wll.entity.baseentity;


import java.util.Date;

/**
 * @Auther HUGH
 * @Date 2018/5/16
 * @Description DateEntity
 */
public class DateEntity<T> extends BaseEntity<T> {
    private String remarks;    // 备注
    //private User createUserId;	// 创建者
    private Date createDate;    // 创建日期
    // protected User updateUserId;	// 更新者
    private Date updateDate;    // 更新日期
    private Boolean deleteTag;    // 删除标记（0：正常；1：删除；2：审核）
    private Date deleteDate;    // 删除日期
    // protected User deleteUserId;	// 创建者


    public DateEntity() {
    super();
    }

    public DateEntity(String id) {
        super(id);
    }


}
