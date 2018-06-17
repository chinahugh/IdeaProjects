package springboot.template.mvc.entity;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table user_info
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class UserInfo {
    /** */
    private String id;

    /** */
    private String userName;

    /** */
    private String userPassword;

    /** 部门id*/
    private SysDepartment department;

    /** 电话*/
    private String phone;

    /** 地址*/
    private String adress;

    /** 邮箱*/
    private String email;

    /** 出生日期*/
    private Date born;

    /** 性别*/
    private Boolean sex;

    /** 头像*/
    private String img;

    /** */
    private String remarks;

    /** */
    private Date createTime;

    /** */
    private String createUserId;

    /** */
    private Date updateTime;

    /** */
    private String updateUserId;

    /** 是否禁用  0否 1是*/
    private Integer isDisable;

    public UserInfo() {
        super();
    }

    public UserInfo(String id, String userName, String userPassword, SysDepartment department, String phone, String adress, String email, Date born, Boolean sex, String img, String remarks, Date createTime, String createUserId, Date updateTime, String updateUserId, Integer isDisable) {
        this.id = id;
        this.userName = userName;
        this.userPassword = userPassword;
        this.department = department;
        this.phone = phone;
        this.adress = adress;
        this.email = email;
        this.born = born;
        this.sex = sex;
        this.img = img;
        this.remarks = remarks;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.updateTime = updateTime;
        this.updateUserId = updateUserId;
        this.isDisable = isDisable;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.id
     *
     * @return the value of user_info.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.id
     *
     * @param id the value for user_info.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id;
    }

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
    public Boolean getSex() {
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
    public void setSex(Boolean sex) {
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

    public SysDepartment getDepartment() {
        return department;
    }

    public void setDepartment(SysDepartment department) {
        this.department = department;
    }
}