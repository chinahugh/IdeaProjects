package springboot.com.mvc.entity;

import springboot.template.mvc.entity.base.DateEntity;

/**
 * @Auther HUGH
 * @Date 2018/8/7
 * @Description SearchEntity 搜索面板类
 */
public class SearchEntity extends DateEntity {
    private static final long serialVersionUID = -7790464099163738986L;

    public SearchEntity() {
        super();
    }

    /**
     * 用户姓名
     */
    private String name;
    private String xmMainDayId;
    private String xmMainMonthId;
    private String sysDeparmentId;
    private Integer sysYear;
    private Integer sysMouth;
    private Integer sysDay;
    /**
     * 页码，从1开始
     */
    private int pageNum;
    /**
     * 页面大小
     */
    private int pageSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getXmMainDayId() {
        return xmMainDayId;
    }

    public void setXmMainDayId(String xmMainDayId) {
        this.xmMainDayId = xmMainDayId;
    }

    public String getXmMainMonthId() {
        return xmMainMonthId;
    }

    public void setXmMainMonthId(String xmMainMonthId) {
        this.xmMainMonthId = xmMainMonthId;
    }

    public String getSysDeparmentId() {
        return sysDeparmentId;
    }

    public void setSysDeparmentId(String sysDeparmentId) {
        this.sysDeparmentId = sysDeparmentId;
    }

    public Integer getSysYear() {
        return sysYear;
    }

    public void setSysYear(Integer sysYear) {
        this.sysYear = sysYear;
    }

    public Integer getSysMouth() {
        return sysMouth;
    }

    public void setSysMouth(Integer sysMouth) {
        this.sysMouth = sysMouth;
    }

    public Integer getSysDay() {
        return sysDay;
    }

    public void setSysDay(Integer sysDay) {
        this.sysDay = sysDay;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
