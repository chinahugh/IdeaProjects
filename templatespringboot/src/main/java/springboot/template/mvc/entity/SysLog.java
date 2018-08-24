package springboot.template.mvc.entity;

import springboot.template.mvc.entity.base.BaseEntity;

import java.util.Date;

/**
 *
 *
 *  sys_log
 *
 *
 */
public class SysLog extends BaseEntity {
    private static final long serialVersionUID = -4984063160181217360L;
    public SysLog(){
      super();
    }
    public SysLog(String id){
        super(id);
    }
    /** 用户名*/
    private String username;

    /** 用户操作*/
    private String operation;

    /** 请求方法*/
    private String method;

    /** 请求参数*/
    private String params;

    /** 执行时长(毫秒)*/
    private Long time;

    /** 是否成功 1 成功 0 失败*/
    private String succeed;

    /** IP地址*/
    private String ip;

    /** 创建时间*/
    private Date createDate;

    /** 结果信息*/
    private String message;

    /**
     *
     *  sys_log.username
     *
     * @return the value of sys_log.username
     *

     */
    public String getUsername() {
        return username;
    }

    /**
     *
     *  sys_log.username
     *
     * @param username the value for sys_log.username
     *

     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     *  sys_log.operation
     *
     * @return the value of sys_log.operation
     *

     */
    public String getOperation() {
        return operation;
    }

    /**
     *
     *  sys_log.operation
     *
     * @param operation the value for sys_log.operation
     *

     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     *
     *  sys_log.method
     *
     * @return the value of sys_log.method
     *

     */
    public String getMethod() {
        return method;
    }

    /**
     *
     *  sys_log.method
     *
     * @param method the value for sys_log.method
     *

     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     *
     *  sys_log.params
     *
     * @return the value of sys_log.params
     *

     */
    public String getParams() {
        return params;
    }

    /**
     *
     *  sys_log.params
     *
     * @param params the value for sys_log.params
     *

     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     *
     *  sys_log.time
     *
     * @return the value of sys_log.time
     *

     */
    public Long getTime() {
        return time;
    }

    /**
     *
     *  sys_log.time
     *
     * @param time the value for sys_log.time
     *

     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     *
     *  sys_log.succeed
     *
     * @return the value of sys_log.succeed
     *

     */
    public String getSucceed() {
        return succeed;
    }

    /**
     *
     *  sys_log.succeed
     *
     * @param succeed the value for sys_log.succeed
     *

     */
    public void setSucceed(String succeed) {
        this.succeed = succeed;
    }

    /**
     *
     *  sys_log.ip
     *
     * @return the value of sys_log.ip
     *

     */
    public String getIp() {
        return ip;
    }

    /**
     *
     *  sys_log.ip
     *
     * @param ip the value for sys_log.ip
     *

     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     *
     *  sys_log.create_date
     *
     * @return the value of sys_log.create_date
     *

     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *
     *  sys_log.create_date
     *
     * @param createDate the value for sys_log.create_date
     *

     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     *
     *  sys_log.message
     *
     * @return the value of sys_log.message
     *

     */
    public String getMessage() {
        return message;
    }

    /**
     *
     *  sys_log.message
     *
     * @param message the value for sys_log.message
     *

     */
    public void setMessage(String message) {
        this.message = message;
    }
}