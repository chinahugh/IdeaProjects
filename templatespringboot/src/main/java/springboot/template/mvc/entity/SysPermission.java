package springboot.template.mvc.entity;

import springboot.template.mvc.entity.base.DateEntity;

/**
 *
 *
 *  sys_permission
 *
 *
 */
public class SysPermission extends DateEntity {
    private static final long serialVersionUID = -308404943148366278L;
    public SysPermission(){
       super();
    }
    public SysPermission(String id){
        super(id);
    }
    /** 程序对应url地址*/
    private String url;

    /** 名称*/
    private String urlName;

    /** 图标*/
    private String urlImg;

    /** 类型 0 url 1 按钮*/
    private Integer type;

    /** 父id*/
    private String fatherId;

    /** 所有父id ','分割*/
    private String fatherIds;

    /** 排序*/
    private Integer sort;

    /** 权限 标识*/
    private String permission;

    /** */
    private String remarks;


    /**
     *
     *  sys_permission.url
     *
     * @return the value of sys_permission.url
     *

     */
    public String getUrl() {
        return url;
    }

    /**
     *
     *  sys_permission.url
     *
     * @param url the value for sys_permission.url
     *

     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     *  sys_permission.url_name
     *
     * @return the value of sys_permission.url_name
     *

     */
    public String getUrlName() {
        return urlName;
    }

    /**
     *
     *  sys_permission.url_name
     *
     * @param urlName the value for sys_permission.url_name
     *

     */
    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    /**
     *
     *  sys_permission.url_img
     *
     * @return the value of sys_permission.url_img
     *

     */
    public String getUrlImg() {
        return urlImg;
    }

    /**
     *
     *  sys_permission.url_img
     *
     * @param urlImg the value for sys_permission.url_img
     *

     */
    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    /**
     *
     *  sys_permission.type
     *
     * @return the value of sys_permission.type
     *

     */
    public Integer getType() {
        return type;
    }

    /**
     *
     *  sys_permission.type
     *
     * @param type the value for sys_permission.type
     *

     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     *
     *  sys_permission.father_id
     *
     * @return the value of sys_permission.father_id
     *

     */
    public String getFatherId() {
        return fatherId;
    }

    /**
     *
     *  sys_permission.father_id
     *
     * @param fatherId the value for sys_permission.father_id
     *

     */
    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    /**
     *
     *  sys_permission.father_ids
     *
     * @return the value of sys_permission.father_ids
     *

     */
    public String getFatherIds() {
        return fatherIds;
    }

    /**
     *
     *  sys_permission.father_ids
     *
     * @param fatherIds the value for sys_permission.father_ids
     *

     */
    public void setFatherIds(String fatherIds) {
        this.fatherIds = fatherIds;
    }

    /**
     *
     *  sys_permission.sort
     *
     * @return the value of sys_permission.sort
     *

     */
    public Integer getSort() {
        return sort;
    }

    /**
     *
     *  sys_permission.sort
     *
     * @param sort the value for sys_permission.sort
     *

     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     *
     *  sys_permission.permission
     *
     * @return the value of sys_permission.permission
     *

     */
    public String getPermission() {
        return permission;
    }

    /**
     *
     *  sys_permission.permission
     *
     * @param permission the value for sys_permission.permission
     *

     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     *
     *  sys_permission.remarks
     *
     * @return the value of sys_permission.remarks
     *

     */
    public String getRemarks() {
        return remarks;
    }

    /**
     *
     *  sys_permission.remarks
     *
     * @param remarks the value for sys_permission.remarks
     *

     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "url='" + url + '\'' +
                ", urlName='" + urlName + '\'' +
                ", urlImg='" + urlImg + '\'' +
                ", type=" + type +
                ", fatherId='" + fatherId + '\'' +
                ", fatherIds='" + fatherIds + '\'' +
                ", sort=" + sort +
                ", permission='" + permission + '\'' +
                ", remarks='" + remarks + '\'' +
                ", createTime=" + createTime +
                ", createUserId='" + createUserId + '\'' +
                ", updateTime=" + updateTime +
                ", updateUserId='" + updateUserId + '\'' +
                ", isNewCreate=" + isNewCreate +
                ", id='" + id + '\'' +
                ", isDisable=" + isDisable +
                '}';
    }
}