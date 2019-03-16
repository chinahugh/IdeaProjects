package springboot.template.global.result;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description RetResult 将结果转化为封装后的结果
 */
public class R extends HashMap implements Serializable {
    private static final long serialVersionUID = -4306581789984092527L;
    private static final String SUCCESS = "SUCCESS";

    public R(RC code, String msg) {
        put("code", code.code);
        put("msg", msg);
    }

    public static R ok() {
        return ok(SUCCESS);
    }

    public static R ok(String msg) {
        return new R(RC.SUCCESS, msg);
    }

    public static R error(String message) {
        return error(RC.FAIL, message);
    }

    public static R error(RC code, String message) {
        return new R(code, message);
    }

    public R put(String name, Object data) {
        super.put(name, data);
        return this;
    }
}
