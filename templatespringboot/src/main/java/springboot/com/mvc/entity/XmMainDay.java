package springboot.com.mvc.entity;

import springboot.template.mvc.entity.base.DateEntity;

/**
 * xm_main_day
 */
public class XmMainDay extends DateEntity {
    private static final long serialVersionUID = 4651794790625258219L;

    public XmMainDay() {
        super();
    }

    public XmMainDay(String id) {
        super(id);
    }

    /**
     * pro_main_id
     */
    private String mainMonthId;
    /**
     * 系统 日（1-31）
     */
    private Integer sysDay;
    /**
     * 早上数据
     */
    private String mData;
    /**
     * 下午数据
     */
    private String pData;
    /**
     * 标志 0正常 1 迟到 2 未打卡 3 外出 4异常
     */
    private Integer mTag;
    /**
     * 标志 0正常 1 早退 2 未打卡 3 外出 4异常
     */
    private Integer pTag;
    /**
     * 备注
     */
    private String remarks;


    /**
     * xm_main_day.sys_day
     *
     * @return the value of xm_main_day.sys_day
     */
    public Integer getSysDay() {
        return sysDay;
    }

    /**
     * xm_main_day.sys_day
     *
     * @param sysDay the value for xm_main_day.sys_day
     */
    public void setSysDay(Integer sysDay) {
        this.sysDay = sysDay;
    }

    /**
     * xm_main_day.m_data
     *
     * @return the value of xm_main_day.m_data
     */
    public String getmData() {
        return mData;
    }

    /**
     * xm_main_day.m_data
     *
     * @param mData the value for xm_main_day.m_data
     */
    public void setmData(String mData) {
        this.mData = mData;
    }

    /**
     * xm_main_day.p_data
     *
     * @return the value of xm_main_day.p_data
     */
    public String getpData() {
        return pData;
    }

    /**
     * xm_main_day.p_data
     *
     * @param pData the value for xm_main_day.p_data
     */
    public void setpData(String pData) {
        this.pData = pData;
    }

    /**
     * xm_main_day.m_tag
     *
     * @return the value of xm_main_day.m_tag
     */
    public Integer getmTag() {
        return mTag;
    }

    /**
     * xm_main_day.m_tag
     *
     * @param mTag the value for xm_main_day.m_tag
     */
    public void setmTag(Integer mTag) {
        this.mTag = mTag;
    }

    /**
     * xm_main_day.p_tag
     *
     * @return the value of xm_main_day.p_tag
     */
    public Integer getpTag() {
        return pTag;
    }

    /**
     * xm_main_day.p_tag
     *
     * @param pTag the value for xm_main_day.p_tag
     */
    public void setpTag(Integer pTag) {
        this.pTag = pTag;
    }

    /**
     * xm_main_day.remarks
     *
     * @return the value of xm_main_day.remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * xm_main_day.remarks
     *
     * @param remarks the value for xm_main_day.remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMainMonthId() {
        return mainMonthId;
    }

    public void setMainMonthId(String mainMonthId) {
        this.mainMonthId = mainMonthId;
    }
}