package springboot.template.mvc.util;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther HUGH
 * @Date 2018/7/15
 * @Description DateUtils
 */
public class DateUtils {
    private static Map<Integer, Integer> map;

    public static Date getNow() {
        return new Date();
    }

    public static Integer getMonthDays(Integer year, Integer month) {
        if (map == null) {
            init();
        }
        //判断是否为闰年
        if (ischeck(year)) {
            map.put(2, 29);
        }
        return map.get(month);
    }

    private static void init() {
        map = new HashMap<Integer, Integer>(12) {
            private static final long serialVersionUID = 7584263869321914894L;

            {
                put(1, 31);
                put(2, 28);
                put(3, 31);
                put(4, 30);
                put(5, 31);
                put(6, 30);
                put(7, 31);
                put(8, 31);
                put(9, 30);
                put(10, 31);
                put(11, 30);
                put(12, 31);
            }
        };
    }

    public static boolean ischeck(int year) {
        if (year <= 0) {
            return false;
        }
        return (year % 4 == 0) && ((year % 100 != 0) | (year % 400 == 0));
    }

    @Test
    public void test() {
        for (int i = 0; i < 2518; i++) {
            if (i % 4 == 0) {
                System.out.println(i + "  " + ischeck(i));
            }
        }
    }
}
