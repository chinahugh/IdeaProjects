package com.springboot.security.common;

import java.util.HashMap;

public class R extends HashMap<String, Object> {
    
    private static final long serialVersionUID = 9182938985439304094L;

    private R(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static R ok() {
        return make(0);
    }

    public static R ok(String msg) {
        return make(0).put("msg", msg);
    }

    public static R ok(Object data) {
        return make(0).put("data", data);
    }

    public static R ok(String msg, Object data) {
        return make(0).put("data", data).put("msg", msg);
    }

    public static R error() {
        return make(1);
    }

    public static R error(String msg) {
        return make(1).put("msg", msg);
    }

    public static R make(int code) {
        R r = new R(4);
        r.put("code", code);
        return r;
    }

}
