package springboot.com.util;

import org.apache.commons.lang.StringUtils;

/**
 * @Auther HUGH
 * @Date 2018/8/9
 * @Description TagUtils
 */
public class TimeTagUtils {
    /**
     * 上班时间 小时
     */
    public final static Integer TIME_SB_H = 9;
    /**
     * 上班时间 分钟
     */
    public final static Integer TIME_SB_M = 00;
    /**
     * 下班时间 小时
     */
    public static Integer TIME_XB_H = 18;
    /**
     * 下班时间 分钟
     */
    public final static Integer TIME_XB_M = 0;
    /**
     * 上班正常
     */
    public final static Integer TAG_ZC = 0;
    /**
     * 上班迟到
     */
    public final static Integer TAG_CD = 1;
    /**
     * 上班早退
     */
    public final static Integer TAG_ZT = 1;
    /**
     * 未打卡
     */
    public final static Integer TAG_WDK = 2;
    /**
     * 数据异常
     */
    public final static Integer TAG_QT = 3;

    /**
     * 根据上班时间返回标志
     *
     * @param mdata
     * @return
     */
    public static Integer getmTag(String mdata) {
        if (StringUtils.isBlank(mdata)) {
            return TAG_WDK;
        }
        String[] split = mdata.split("[:]");
        if (split.length != 2) {
            return TAG_QT;
        }
        if (Integer.parseInt(split[0].trim()) > TIME_SB_H) {
            return TAG_CD;
        }
        if (Integer.parseInt(split[0].trim()) == TIME_SB_H) {
            if (Integer.parseInt(split[1].trim()) > TIME_SB_M) {
                return TAG_CD;
            }
        }
        return TAG_ZC;
    }

    /**
     * 根据下班时间返回标志
     *
     * @param pdata
     * @return
     */
    public static Integer getpTag(String pdata) {
        if (StringUtils.isBlank(pdata)) {
            return TAG_WDK;
        }
        String[] split = pdata.split("[:]");
        if (split.length != 2) {
            return TAG_QT;
        }
        if (Integer.parseInt(split[0].trim()) < TIME_XB_H) {
            return TAG_ZT;
        }
        if (Integer.parseInt(split[0].trim()) == TIME_XB_H) {
            if (Integer.parseInt(split[1].trim()) < TIME_XB_M) {
                return TAG_ZT;
            }
        }
        return TAG_ZC;
    }

    public static void main(String[] args) {
        //System.out.println(getmTag("09:10"));
        System.out.println(getpTag("17:59  "));
    }
}
