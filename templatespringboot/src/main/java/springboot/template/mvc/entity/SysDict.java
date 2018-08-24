package springboot.template.mvc.entity;

import springboot.template.mvc.entity.base.DateEntity;


/**
 *
 *
 *  sys_dict
 *
 *
 */
public class SysDict extends DateEntity {
    private static final long serialVersionUID = -2523716500208390626L;
    public SysDict(){
      super();
    }

    public SysDict(String id) {
        super(id);
    }
    /** 字典名称*/
    private String name;

    /** 字典类型*/
    private String type;

    /** 字典码*/
    private String lable;

    /** 字典值*/
    private String value;

    /** 排序*/
    private Integer sort;

    /** 备注*/
    private String remark;


    /**
     *
     *  sys_dict.name
     *
     * @return the value of sys_dict.name
     *

     */
    public String getName() {
        return name;
    }

    /**
     *
     *  sys_dict.name
     *
     * @param name the value for sys_dict.name
     *

     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     *  sys_dict.type
     *
     * @return the value of sys_dict.type
     *

     */
    public String getType() {
        return type;
    }

    /**
     *
     *  sys_dict.type
     *
     * @param type the value for sys_dict.type
     *

     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     *  sys_dict.lable
     *
     * @return the value of sys_dict.lable
     *

     */
    public String getLable() {
        return lable;
    }

    /**
     *
     *  sys_dict.lable
     *
     * @param lable the value for sys_dict.lable
     *

     */
    public void setLable(String lable) {
        this.lable = lable;
    }

    /**
     *
     *  sys_dict.value
     *
     * @return the value of sys_dict.value
     *

     */
    public String getValue() {
        return value;
    }

    /**
     *
     *  sys_dict.value
     *
     * @param value the value for sys_dict.value
     *

     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     *  sys_dict.sort
     *
     * @return the value of sys_dict.sort
     *

     */
    public Integer getSort() {
        return sort;
    }

    /**
     *
     *  sys_dict.sort
     *
     * @param sort the value for sys_dict.sort
     *

     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     *
     *  sys_dict.remark
     *
     * @return the value of sys_dict.remark
     *

     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     *  sys_dict.remark
     *
     * @param remark the value for sys_dict.remark
     *

     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

}