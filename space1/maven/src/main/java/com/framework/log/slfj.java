package com.framework.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author HUGH
 * @Date 2018/11/26 21:36 日志框架学习
 * @Description slfj
 */
public class slfj {
    Logger logger = LoggerFactory.getLogger(slfj.class);

    public static void main(String[] args) {
        slfj slfj = new slfj();
        slfj.test();
    }

    private void test() {
        logger.info("asdasd {},jskdfhsfhaslkdjf   {}", 1, "adsad");
        logger.trace("=====trace=====");
        logger.debug("=====debug=====");
        logger.info("=====info=====");
        logger.warn("=====warn=====");
        logger.error("=====error=====");
        logger.info(new RuntimeException("asda").getMessage());
    }
    @Test
    public void aa(){
        logger.debug(new RuntimeException("asd").getMessage());
    }
}
