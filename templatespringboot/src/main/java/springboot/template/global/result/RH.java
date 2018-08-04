package springboot.template.global.result;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther HUGH
 * @Date 2018/7/31
 * @Description RH
 */
public class RH extends HashMap<String, Object> {
    private static final long serialVersionUID = -8977257753266864939L;
    private RH() {
        put("code", 200);
        put("msg", "success");
    }

    public static RH error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static RH error(String msg) {
        return error(400, msg);
    }

    public static RH error(int code, String msg) {
        RH r = new RH();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static RH ok(String msg) {
        RH r = new RH();
        r.put("msg", msg);
        return r;
    }

    public static RH ok(Map<String, Object> map) {
        RH r = new RH();
        r.putAll(map);
        return r;
    }

    public static RH ok() {
        return new RH();
    }

    @Override
    public RH put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
