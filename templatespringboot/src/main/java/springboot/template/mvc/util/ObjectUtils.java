package springboot.template.mvc.util;

import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * @Auther HUGH
 * @Date 2018/7/15
 * @Description ObjectUtils
 */
public class ObjectUtils {
    public static boolean isNotNULL(Object o) {
        return !isNULL(o);
    }

    public static boolean isNULL(Object o) {
        boolean isNull = true;
        if (o != null) {
            isNull = false;
            if (o instanceof String) {
                String str = ((String) o).trim();
                if (str.isEmpty() || StringUtils.EMPTY.equalsIgnoreCase(str)) {
                    isNull = true;
                }
            }
        }
        return isNull;
    }

    public static void main(String[] args) {
        Date date = new Date();
        boolean notNULL = isNotNULL("       ");
        System.out.println(notNULL);
    }
}
