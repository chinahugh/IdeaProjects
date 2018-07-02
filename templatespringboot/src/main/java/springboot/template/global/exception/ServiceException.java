package springboot.template.global.exception;

import java.io.Serializable;

/**
 * @Auther HUGH
 * @Date 2018/6/9
 * @Description ServiceException 业务类异常
 */


public class ServiceException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -7763139086868275378L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
