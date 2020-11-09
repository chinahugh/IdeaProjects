package com.datasource.common;

/**
 * 自定义异常
 *
 * @author HGH
 */
public class E extends RuntimeException {

    private static final long serialVersionUID = 4673163304817828153L;


    public E(String message) {
        super(message);
    }

    public E(String message, Throwable cause) {
        super(message + " : " + cause.getMessage(), cause);
    }

    public E(Throwable cause) {
        super(cause);
    }

}
