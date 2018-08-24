package springboot.template.mvc.entity;

import springboot.template.mvc.entity.base.DateEntity;


/**
 *
 *  sys_department
 *
 do_not_delete_uring_merge
 */
public class SysDepartment extends DateEntity {
    private static final long serialVersionUID = 5286463876425329863L;

    public SysDepartment() {
       super();
    }

    public SysDepartment(String id) {
        super(id);
    }

    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 父部门id
     */
    private String fatherId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 备注
     */
    private String remarks;

    /**
     *
     *  sys_department.department_name
     *
     * @return the value of sys_department.department_name

     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     *
     *  sys_department.department_name
     *
     * @param departmentName the value for sys_department.department_name

     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     *
     *  sys_department.father_id
     *
     * @return the value of sys_department.father_id

     */
    public String getFatherId() {
        return fatherId;
    }

    /**
     *
     *  sys_department.father_id
     *
     * @param fatherId the value for sys_department.father_id

     */
    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    /**
     *
     *  sys_department.sort
     *
     * @return the value of sys_department.sort

     */
    public Integer getSort() {
        return sort;
    }

    /**
     *
     *  sys_department.sort
     *
     * @param sort the value for sys_department.sort

     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }


    /**
     *
     *  sys_department.remarks
     *
     * @return the value of sys_department.remarks

     */
    public String getRemarks() {
        return remarks;
    }

    /**
     *
     *  sys_department.remarks
     *
     * @param remarks the value for sys_department.remarks

     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "SysDepartment{" +
                "departmentName='" + departmentName + '\'' +
                ", fatherId='" + fatherId + '\'' +
                ", sort=" + sort +
                ", remarks='" + remarks + '\'' +
                ", createTime=" + createTime +
                ", createUserId='" + createUserId + '\'' +
                ", updateTime=" + updateTime +
                ", updateUserId='" + updateUserId + '\'' +
                ", isDisable=" + isDisable +
                ", isNewCreate=" + isNewCreate +
                ", id='" + id + '\'' +
                '}';
    }
}