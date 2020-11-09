package com.datasource.config;

import com.datasource.common.E;
import com.datasource.common.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 统一异常处理
 *
 * @author HGH
 */
@ResponseBody
@ControllerAdvice
public class ExceptionHandlerConfig {
    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerConfig.class);

    @ExceptionHandler(E.class)
    public R e(E e) {
        logger.error("catch exception : {}\r\n exception:", e.getMessage(), e);
        return R.make(991).put("msg", e.getMessage());
    }
    @ExceptionHandler(RuntimeException.class)
    public R runtimeException(RuntimeException e) {
        logger.error("catch exception : {}\r\n exception:", e.getMessage(), e);
        return R.make(997).put("msg", e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    public R runtimeException(BindException e) {
        StringBuilder errormsg = new StringBuilder();
        List<ObjectError> allErrors = e.getAllErrors();
        for (int i = 0; i < allErrors.size(); i++) {
            errormsg.append(allErrors.get(i).getDefaultMessage());
            if (i != allErrors.size() - 1) {
                errormsg.append(",");
            }
        }
        String msg = errormsg.toString();
        logger.error("catch exception : {}\r\n exception:", msg, e);
        return R.make(998).put("msg", msg);
    }

    @ExceptionHandler(Exception.class)
    public R exception(Exception e) {
        logger.error("catch exception : {}\r\n exception:", e.getMessage(), e);
        return R.make(999).put("msg", e.getMessage());
    }
}
