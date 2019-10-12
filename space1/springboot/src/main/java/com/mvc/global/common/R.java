package com.mvc.global.common;

import java.util.HashMap;

/**
 * @author HUGH
 * @Date 2019/7/28 10:08
 * @Description R 封装返回
 */
public class R extends HashMap<String, Object> {
    private R(Integer code, String msg) {
        put("code", code);
        put("msg", msg);
    }

    public static R make(Integer code, String msg) {
        return new R(code, msg);
    }

    public static R ok() {
        return make(0, "success");
    }

    public static R ok(Object data) {
        return ok().putData(data);
    }

    public static R error(Integer code, String msg) {
        return make(code, msg);
    }

    public static R error(String msg) {
        return make(1, msg);
    }

    public R putData(Object data) {
        return this.put("data", data);
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
