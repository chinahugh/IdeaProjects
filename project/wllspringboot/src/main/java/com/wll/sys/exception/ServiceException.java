package com.wll.sys.exception;

import java.io.Serializable;

/**
 * @Auther HUGH
 * @Date 2018/6/8
 * @Description ServiceException
 */
public class ServiceException extends RuntimeException implements Serializable {
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    protected ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
