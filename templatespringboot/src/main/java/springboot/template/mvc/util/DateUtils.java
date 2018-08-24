package springboot.template.mvc.util;

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

    public static Integer getMonthDays(Integer month) {
        if (map == null) {
            init();
        }
        return map.get(month);
    }

    private static void init() {
        map = new HashMap<>(12);
        map.put(1, 31);
        map.put(2, 28);
        map.put(3, 31);
        map.put(4, 30);
        map.put(5, 31);
        map.put(6, 30);
        map.put(7, 31);
        map.put(8, 31);
        map.put(9, 30);
        map.put(10, 31);
        map.put(11, 30);
        map.put(12, 31);
    }
}
