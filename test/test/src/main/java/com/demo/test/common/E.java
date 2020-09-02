package com.demo.test.common;

/**
 * @author HGH
 */
public class E extends RuntimeException {
    private static final long serialVersionUID = 2875836785144698981L;

    public E() {
        super();
    }

    public E(String message) {
        super(message);
    }

    public E(String message, Throwable cause) {
        super(message, cause);
    }

    public E(Throwable cause) {
        super(cause);
    }
}
