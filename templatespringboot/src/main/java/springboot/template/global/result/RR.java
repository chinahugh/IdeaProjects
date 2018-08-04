package springboot.template.global.result;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description RetResponse 将结果转化为封装后的结果
 */
public class RR {
    private final static String SUCCESS = "success";

    public static R makeR(RC code, String msg, Map data) {
        return new R(code, msg, data);
    }

    public static R ok() {
        return ok(SUCCESS);
    }

    public static R ok(String msg) {
        return makeR(RC.SUCCESS, msg, null);
    }

    public static R ok(Map data) {
        return makeR(RC.SUCCESS, SUCCESS, data);
    }

    public static R error(String message) {
        return error(RC.FAIL, message);
    }
    public static R error(RC rc,String message) {
        return makeR(rc, message, null);
    }

    public static Map<String, Object> getMap(int initialCapacity) {
        return new HashMap<>(initialCapacity);
    }
    public static Map<String, Object> getMap() {
        return getMap(5);
    }
}
