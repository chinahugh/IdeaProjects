package springboot.template.mvc.entity.base;

import springboot.template.mvc.util.DateUtils;

import java.util.Date;

/**
 * @Auther HUGH
 * @Date 2018/7/15
 * @Description DateEntity
 */
public class DateEntity extends BaseEntity {
    private static final long serialVersionUID = 7890837950729944006L;
    /** */
    protected Date createTime;
    /** */
    protected String createUserId;
    /** */
    protected Date updateTime;
    /** */
    protected String updateUserId;

    public DateEntity() {
        super();
    }

    public DateEntity(String id) {
        super(id);
    }

    /**
     * sys_department.create_time
     *
     * @return the value of sys_department.create_time
     *
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * sys_department.create_time
     *
     * @param createTime the value for sys_department.create_time
     *
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * sys_department.create_user_id
     *
     * @return the value of sys_department.create_user_id
     *
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * sys_department.create_user_id
     *
     * @param createUserId the value for sys_department.create_user_id
     *
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * sys_department.update_time
     *
     * @return the value of sys_department.update_time
     *
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * sys_department.update_time
     *
     * @param updateTime the value for sys_department.update_time
     *
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * sys_department.update_user_id
     *
     * @return the value of sys_department.update_user_id
     *
     */
    public String getUpdateUserId() {
        return updateUserId;
    }

    /**
     * sys_department.update_user_id
     *
     * @param updateUserId the value for sys_department.update_user_id
     *
     */
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public void initDateEntity() {
        if (this.createTime == null) {
            this.updateTime = DateUtils.getNow();
        } else {
            this.updateTime = DateUtils.getNow();
        }
    }
}
