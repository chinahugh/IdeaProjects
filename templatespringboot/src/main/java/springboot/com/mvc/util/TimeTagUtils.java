package springboot.com.mvc.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @Auther HUGH
 * @Date 2018/8/9
 * @Description TagUtils
 */
public final class TimeTagUtils {
    private static Logger logger = LoggerFactory.getLogger(TimeTagUtils.class);
    /**
     * 上班时间 小时
     */
    public final static Integer TIME_SB_H = 9;
    /**
     * 上班时间 分钟
     */
    public final static Integer TIME_SB_M = 0;
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
    public final static String TAG_ZC = "1";
    /**
     * 上班迟到
     */
    public final static String TAG_CD = "2";
    /**
     * 上班早退
     */
    public final static String TAG_ZT = "3";
    /**
     * 未打卡
     */
    public final static String TAG_WDK = "0";
    /**
     * 数据异常
     */
    public final static String TAG_QT = "4";

    /**
     * 根据上班时间返回标志
     *
     * @param mdata
     * @return
     */
    public static String getmTag(String mdata) {
        //未打卡
        if (StringUtils.isBlank(mdata)) {
            return TAG_WDK;
        }
        String[] split = mdata.split("[:]");
        //数据异常
        if (split.length != 2) {
            return TAG_QT;
        }
        //迟到
        if (Integer.parseInt(split[0].trim()) > TIME_SB_H) {
            return TAG_CD;
        }
        //迟到
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
    public static String getpTag(String pdata) {
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
        System.out.println(Arrays.toString(decomposition("08:5718:14  ")));
    }

    /**
     * 解析一个单元格的考勤，取出最早的打卡日期和最晚的日期，
     * 格式有：08:35、08:5518:57、08:5718:1418:24
     *
     * @param day
     * @return
     */
    public static String[] decomposition(String day) {
        if (day == null) {
            logger.info("单元格的考勤为空！！！");
            return null;
        }
        if (day.trim().length() < 5 && day.trim().length() % 5 == 0) {
            logger.info("单元格的考勤错误！！！");
            return null;
        }
        String[] data = new String[2];
        int num = day.trim().length() / 5;
        if (num == 1) {
            data[0] = day.trim().substring(0, 5);
        } else {
            data[0] = day.trim().substring(0, 5);
            data[1] = day.trim().substring((num - 1) * 5, num * 5);
        }
        return data;
    }
}
