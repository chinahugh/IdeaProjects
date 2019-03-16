package springboot.com.mvc.entity;

/**
 * @author HUGH
 * @Date 2019/2/27 21:32
 * @Description MapperResultType
 */
public class MapperResultType {
    private String userId;
    private int sysMonth;
    private int sysTYear;
    private int mTag;
    private int pTag;
    private int count;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSysMonth() {
        return sysMonth;
    }

    public void setSysMonth(int sysMonth) {
        this.sysMonth = sysMonth;
    }

    public int getSysTYear() {
        return sysTYear;
    }

    public void setSysTYear(int sysTYear) {
        this.sysTYear = sysTYear;
    }

    public int getmTag() {
        return mTag;
    }

    public void setmTag(int mTag) {
        this.mTag = mTag;
    }

    public int getpTag() {
        return pTag;
    }

    public void setpTag(int pTag) {
        this.pTag = pTag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MapperResultType{" +
                "userId='" + userId + '\'' +
                ", sysMonth=" + sysMonth +
                ", sysTYear=" + sysTYear +
                ", mTag=" + mTag +
                ", pTag=" + pTag +
                ", count=" + count +
                '}';
    }
}
