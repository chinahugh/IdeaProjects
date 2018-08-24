package springboot.template.mvc.entity;

import springboot.template.mvc.entity.base.DateEntity;

/**
 *
 *  sys_role
 *
 *
 */
public class SysRole extends DateEntity {
    private static final long serialVersionUID = -658917899770511509L;

    public SysRole() {
        super();
    }

    public SysRole(String id) {
        super(id);
        isDisable = 0;
    }

    /**
     * 角色名称，用于显示
     */
    private String roleName;
    /**
     * 角色值，用于权限判断
     */
    private String roleValue;
    /**
     * 父角色id
     */
    private String fatherId;
    /**
     * 部门id
     */
    private String departmentId;
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
     *  sys_role.role_name
     *
     * @return the value of sys_role.role_name

     */
    public String getRoleName() {
        return roleName;
    }

    /**
     *
     *  sys_role.role_name
     *
     * @param roleName the value for sys_role.role_name

     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     *
     *  sys_role.role_value
     *
     * @return the value of sys_role.role_value

     */
    public String getRoleValue() {
        return roleValue;
    }

    /**
     *
     *  sys_role.role_value
     *
     * @param roleValue the value for sys_role.role_value

     */
    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    /**
     *
     *  sys_role.father_id
     *
     * @return the value of sys_role.father_id

     */
    public String getFatherId() {
        return fatherId;
    }

    /**
     *
     *  sys_role.father_id
     *
     * @param fatherId the value for sys_role.father_id

     */
    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    /**
     *
     *  sys_role.department_id
     *
     * @return the value of sys_role.department_id

     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     *
     *  sys_role.department_id
     *
     * @param departmentId the value for sys_role.department_id

     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     *
     *  sys_role.sort
     *
     * @return the value of sys_role.sort

     */
    public Integer getSort() {
        return sort;
    }

    /**
     *
     *  sys_role.sort
     *
     * @param sort the value for sys_role.sort

     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     *
     *  sys_role.remarks
     *
     * @return the value of sys_role.remarks

     */
    public String getRemarks() {
        return remarks;
    }

    /**
     *
     *  sys_role.remarks
     *
     * @param remarks the value for sys_role.remarks

     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}