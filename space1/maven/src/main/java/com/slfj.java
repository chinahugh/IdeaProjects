package com;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author HUGH
 * @Date 2018/11/26 21:36
 * @Description slfj
 */
public class slfj {
    Logger logger = LoggerFactory.getLogger(com.slfj.class);

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
        Object o;
        logger.debug(new RuntimeException("asd").getMessage());
    }
}
