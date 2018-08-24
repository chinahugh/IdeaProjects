package springboot.com.mvc.entity;

import springboot.template.mvc.entity.base.DateEntity;

import java.util.List;

/**
 * xm_main_month
 */
public class XmMainMonth extends DateEntity {
    private static final long serialVersionUID = 6595086923934785650L;

    public XmMainMonth() {
    }

    public XmMainMonth(String id) {
        super(id);
    }

    /** */
    private String userId;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 系统 年
     */
    private Integer sysYear;
    /**
     * 系统 月
     */
    private Integer sysMonth;
    /**
     * 应出勤天数
     */
    private Integer ycqts;
    /**
     * 实际出勤天数
     */
    private Integer sjcqts;
    /**
     * 事假天数
     */
    private Integer sj;
    /**
     * 病假天数
     */
    private Integer bj;
    /**
     * 年假天数
     */
    private Integer nj;
    /**
     * 婚假天数
     */
    private Integer hj;
    /**
     * 缺勤天数
     */
    private Integer qq;
    /**
     * 旷工天数
     */
    private Integer kg;
    /**
     * 忘打卡次数
     */
    private Integer wdk;
    /**
     * 迟到次数
     */
    private Integer cd;
    /**
     * 早退次数
     */
    private Integer zt;
    /**
     * 备注
     */
    private String remarks;
    private List<XmMainDay> xmMainDays;

    /**
     * xm_main_month.user_id
     *
     * @return the value of xm_main_month.user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * xm_main_month.user_id
     *
     * @param userId the value for xm_main_month.user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * xm_main_month.sort
     *
     * @return the value of xm_main_month.sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * xm_main_month.sort
     *
     * @param sort the value for xm_main_month.sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * xm_main_month.sys_year
     *
     * @return the value of xm_main_month.sys_year
     */
    public Integer getSysYear() {
        return sysYear;
    }

    /**
     * xm_main_month.sys_year
     *
     * @param sysYear the value for xm_main_month.sys_year
     */
    public void setSysYear(Integer sysYear) {
        this.sysYear = sysYear;
    }

    /**
     * xm_main_month.sys_month
     *
     * @return the value of xm_main_month.sys_month
     */
    public Integer getSysMonth() {
        return sysMonth;
    }

    /**
     * xm_main_month.sys_month
     *
     * @param sysMonth the value for xm_main_month.sys_month
     */
    public void setSysMonth(Integer sysMonth) {
        this.sysMonth = sysMonth;
    }

    /**
     * xm_main_month.ycqts
     *
     * @return the value of xm_main_month.ycqts
     */
    public Integer getYcqts() {
        return ycqts;
    }

    /**
     * xm_main_month.ycqts
     *
     * @param ycqts the value for xm_main_month.ycqts
     */
    public void setYcqts(Integer ycqts) {
        this.ycqts = ycqts;
    }

    /**
     * xm_main_month.sjcqts
     *
     * @return the value of xm_main_month.sjcqts
     */
    public Integer getSjcqts() {
        return sjcqts;
    }

    /**
     * xm_main_month.sjcqts
     *
     * @param sjcqts the value for xm_main_month.sjcqts
     */
    public void setSjcqts(Integer sjcqts) {
        this.sjcqts = sjcqts;
    }

    /**
     * xm_main_month.sj
     *
     * @return the value of xm_main_month.sj
     */
    public Integer getSj() {
        return sj;
    }

    /**
     * xm_main_month.sj
     *
     * @param sj the value for xm_main_month.sj
     */
    public void setSj(Integer sj) {
        this.sj = sj;
    }

    /**
     * xm_main_month.bj
     *
     * @return the value of xm_main_month.bj
     */
    public Integer getBj() {
        return bj;
    }

    /**
     * xm_main_month.bj
     *
     * @param bj the value for xm_main_month.bj
     */
    public void setBj(Integer bj) {
        this.bj = bj;
    }

    /**
     * xm_main_month.nj
     *
     * @return the value of xm_main_month.nj
     */
    public Integer getNj() {
        return nj;
    }

    /**
     * xm_main_month.nj
     *
     * @param nj the value for xm_main_month.nj
     */
    public void setNj(Integer nj) {
        this.nj = nj;
    }

    /**
     * xm_main_month.hj
     *
     * @return the value of xm_main_month.hj
     */
    public Integer getHj() {
        return hj;
    }

    /**
     * xm_main_month.hj
     *
     * @param hj the value for xm_main_month.hj
     */
    public void setHj(Integer hj) {
        this.hj = hj;
    }

    /**
     * xm_main_month.qq
     *
     * @return the value of xm_main_month.qq
     */
    public Integer getQq() {
        return qq;
    }

    /**
     * xm_main_month.qq
     *
     * @param qq the value for xm_main_month.qq
     */
    public void setQq(Integer qq) {
        this.qq = qq;
    }

    /**
     * xm_main_month.kg
     *
     * @return the value of xm_main_month.kg
     */
    public Integer getKg() {
        return kg;
    }

    /**
     * xm_main_month.kg
     *
     * @param kg the value for xm_main_month.kg
     */
    public void setKg(Integer kg) {
        this.kg = kg;
    }

    /**
     * xm_main_month.wdk
     *
     * @return the value of xm_main_month.wdk
     */
    public Integer getWdk() {
        return wdk;
    }

    /**
     * xm_main_month.wdk
     *
     * @param wdk the value for xm_main_month.wdk
     */
    public void setWdk(Integer wdk) {
        this.wdk = wdk;
    }

    /**
     * xm_main_month.cd
     *
     * @return the value of xm_main_month.cd
     */
    public Integer getCd() {
        return cd;
    }

    /**
     * xm_main_month.cd
     *
     * @param cd the value for xm_main_month.cd
     */
    public void setCd(Integer cd) {
        this.cd = cd;
    }

    /**
     * xm_main_month.zt
     *
     * @return the value of xm_main_month.zt
     */
    public Integer getZt() {
        return zt;
    }

    /**
     * xm_main_month.zt
     *
     * @param zt the value for xm_main_month.zt
     */
    public void setZt(Integer zt) {
        this.zt = zt;
    }

    /**
     * xm_main_month.remarks
     *
     * @return the value of xm_main_month.remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * xm_main_month.remarks
     *
     * @param remarks the value for xm_main_month.remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<XmMainDay> getXmMainDays() {
        return xmMainDays;
    }

    public void setXmMainDays(List<XmMainDay> xmMainDays) {
        this.xmMainDays = xmMainDays;
    }
}