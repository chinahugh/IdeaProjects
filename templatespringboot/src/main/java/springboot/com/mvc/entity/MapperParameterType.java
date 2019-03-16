package springboot.com.mvc.entity;

/**
 * @author HUGH
 * @Date 2019/2/27 21:29
 * @Description MapperParameterType
 */
public class MapperParameterType {
    private int[] pTag;
    private int[] mTag;
    private int sysMonth;
    private int sysYear;

    public MapperParameterType() {
    }

    public MapperParameterType(int[] pTag, int[] mTag, int sysMonth, int sysYear) {
        this.pTag = pTag;
        this.mTag = mTag;
        this.sysMonth = sysMonth;
        this.sysYear = sysYear;
    }

    public int[] getpTag() {
        return pTag;
    }

    public void setpTag(int[] pTag) {
        this.pTag = pTag;
    }

    public int[] getmTag() {
        return mTag;
    }

    public void setmTag(int[] mTag) {
        this.mTag = mTag;
    }

    public int getSysMonth() {
        return sysMonth;
    }

    public void setSysMonth(int sysMonth) {
        this.sysMonth = sysMonth;
    }

    public int getSysYear() {
        return sysYear;
    }

    public void setSysYear(int sysYear) {
        this.sysYear = sysYear;
    }
}
