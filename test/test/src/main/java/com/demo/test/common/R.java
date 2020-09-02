package com.demo.test.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.HashMap;

/**
 * @author HGH
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 6153456015623622891L;

    private R() {
        super();
    }

    private static R make(Integer code) {
        R r = new R();
        r.put("code", code);
        return r;
    }

    public static R ok() {
        return make(0);
    }

    public static R ok(Object data) {
        return make(0).put("data", data);
    }

    public static R ok(Page page) {
        R r = make(0);
        r.put("data", page.getRecords());
        r.put("next", page.hasNext());
        r.put("previous", page.hasPrevious());
        r.put("current", page.getCurrent());
        r.put("total", page.getTotal());
        r.put("size", page.getSize());
        return r;
    }


    public static R error() {
        return make(1);
    }

    public static R error(String msg) {
        return make(1).put("msg", msg);
    }

//    public static R r(Integer code) {
//        return make(code);
//    }


    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
