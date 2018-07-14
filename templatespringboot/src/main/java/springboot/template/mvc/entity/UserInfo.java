package springboot.template.mvc.entity;

import springboot.template.mvc.entity.base.BaseEntity;

import java.util.Date;
import java.util.Set;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table user_info
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class UserInfo extends BaseEntity {
    private static final long serialVersionUID = -8715672633099090133L;
    /** 登录名*/
    private String userName;

    /** 密码*/
    private String userPassword;

    /** 部门id*/
    private String departmentId;

    /** 电话*/
    private String phone;

    /** 地址*/
    private String adress;

    /** 邮箱*/
    private String email;

    /** 出生日期*/
    private Date born;

    /** 性别(1 男 2 女 0未知)*/
    private Integer sex;

    /** 头像*/
    private String img;

    /** 备注*/
    private String remarks;

    /** 本次登录ip*/
    private String thisLoginIp;

    /** 本次登录时间*/
    private Date thisLoginTime;

    /** 上次登录ip*/
    private String lastLoginIp;

    /** 上次登录时间*/
    private Date lastLoginTime;

    /** */
    private Date createTime;

    /** */
    private String createUserId;

    /** */
    private Date updateTime;

    /** */
    private String updateUserId;

    /** 是否禁用 0否 1是 2 待审核*/
    private Integer isDisable;
    private Set<String> roles;
    private Set<String> permissions;


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_name
     *
     * @return the value of user_info.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_name
     *
     * @param userName the value for user_info.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.user_password
     *
     * @return the value of user_info.user_password
     *
     * @mbg.generated
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.user_password
     *
     * @param userPassword the value for user_info.user_password
     *
     * @mbg.generated
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.department_id
     *
     * @return the value of user_info.department_id
     *
     * @mbg.generated
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.department_id
     *
     * @param departmentId the value for user_info.department_id
     *
     * @mbg.generated
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.phone
     *
     * @return the value of user_info.phone
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.phone
     *
     * @param phone the value for user_info.phone
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.adress
     *
     * @return the value of user_info.adress
     *
     * @mbg.generated
     */
    public String getAdress() {
        return adress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.adress
     *
     * @param adress the value for user_info.adress
     *
     * @mbg.generated
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.email
     *
     * @return the value of user_info.email
     *
     * @mbg.generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.email
     *
     * @param email the value for user_info.email
     *
     * @mbg.generated
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.born
     *
     * @return the value of user_info.born
     *
     * @mbg.generated
     */
    public Date getBorn() {
        return born;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.born
     *
     * @param born the value for user_info.born
     *
     * @mbg.generated
     */
    public void setBorn(Date born) {
        this.born = born;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.sex
     *
     * @return the value of user_info.sex
     *
     * @mbg.generated
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.sex
     *
     * @param sex the value for user_info.sex
     *
     * @mbg.generated
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.img
     *
     * @return the value of user_info.img
     *
     * @mbg.generated
     */
    public String getImg() {
        return img;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.img
     *
     * @param img the value for user_info.img
     *
     * @mbg.generated
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.remarks
     *
     * @return the value of user_info.remarks
     *
     * @mbg.generated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.remarks
     *
     * @param remarks the value for user_info.remarks
     *
     * @mbg.generated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.this_login_ip
     *
     * @return the value of user_info.this_login_ip
     *
     * @mbg.generated
     */
    public String getThisLoginIp() {
        return thisLoginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.this_login_ip
     *
     * @param thisLoginIp the value for user_info.this_login_ip
     *
     * @mbg.generated
     */
    public void setThisLoginIp(String thisLoginIp) {
        this.thisLoginIp = thisLoginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.this_login_time
     *
     * @return the value of user_info.this_login_time
     *
     * @mbg.generated
     */
    public Date getThisLoginTime() {
        return thisLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.this_login_time
     *
     * @param thisLoginTime the value for user_info.this_login_time
     *
     * @mbg.generated
     */
    public void setThisLoginTime(Date thisLoginTime) {
        this.thisLoginTime = thisLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.last_login_ip
     *
     * @return the value of user_info.last_login_ip
     *
     * @mbg.generated
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.last_login_ip
     *
     * @param lastLoginIp the value for user_info.last_login_ip
     *
     * @mbg.generated
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.last_login_time
     *
     * @return the value of user_info.last_login_time
     *
     * @mbg.generated
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.last_login_time
     *
     * @param lastLoginTime the value for user_info.last_login_time
     *
     * @mbg.generated
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.create_time
     *
     * @return the value of user_info.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.create_time
     *
     * @param createTime the value for user_info.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.create_user_id
     *
     * @return the value of user_info.create_user_id
     *
     * @mbg.generated
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.create_user_id
     *
     * @param createUserId the value for user_info.create_user_id
     *
     * @mbg.generated
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.update_time
     *
     * @return the value of user_info.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.update_time
     *
     * @param updateTime the value for user_info.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.update_user_id
     *
     * @return the value of user_info.update_user_id
     *
     * @mbg.generated
     */
    public String getUpdateUserId() {
        return updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.update_user_id
     *
     * @param updateUserId the value for user_info.update_user_id
     *
     * @mbg.generated
     */
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.is_disable
     *
     * @return the value of user_info.is_disable
     *
     * @mbg.generated
     */
    public Integer getIsDisable() {
        return isDisable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.is_disable
     *
     * @param isDisable the value for user_info.is_disable
     *
     * @mbg.generated
     */
    public void setIsDisable(Integer isDisable) {
        this.isDisable = isDisable;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}