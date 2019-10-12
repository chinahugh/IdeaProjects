package com.mvc.global.common;

import java.io.Serializable;

/**
 * @author HUGH
 * @Date 2019/7/28 10:32
 * @Description E 异常封装
 */
public class E extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -3207101201514810966L;
    private Integer code = 1;

    public E(String message) {
        super(message);
    }

    public E(String message, Throwable cause) {
        super(message, cause);
    }

    public E(Throwable cause) {
        super(cause);
    }

    public E(Integer code, String message) {
        super(message);
        this.code=code;
    }

    public E(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code=code;
    }

    public E(Integer code, Throwable cause) {
        super(cause);
        this.code=code;
    }

    public Integer getCode() {
        return code;
    }
}
