package com.datasource.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
 
import java.util.LinkedHashMap;
import java.util.Objects;

/**
 * 自定义返回类型
 *
 * @author HGH
 */
public class R extends LinkedHashMap<String, Object>{
    private static final long serialVersionUID = 4626535312542645606L;

    private final Logger logger = LoggerFactory.getLogger(R.class);

    private R() {
        super(4);
    }

    @Override
    public R put(String key, Object value) {
        if (StringUtils.isEmpty(key) || Objects.isNull(value) || "".equals(value.toString())) {
            logger.error("The key-value pair put into the map is empty, key:'{}',value:'{}',R:'{}'", key, value, this);
        } else {
            super.put(key, value);
        }
        return this;
    }

    public static R make(int code) {
        return new R().put("code", code);
    }

    public static R ok() {
        return make(0);
    }

    public static R ok(Object data) {
        return make(0).put("data", data);
    }

    public static R ok(String msg) {
        return make(0).put("msg", msg);
    }

    public static R error(String msg) {
        return make(1).put("msg", msg);
    }

}
