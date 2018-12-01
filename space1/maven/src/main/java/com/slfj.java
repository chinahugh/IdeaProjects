package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author HUGH
 * @Date 2018/11/26 21:36
 * @Description slfj
 */
public class slfj {
    Logger logger= LoggerFactory.getLogger(com.slfj.class);

    public static void main(String[] args) {
        slfj slfj = new slfj();
        slfj.test();
    }

    private void test() {
        logger.info("asdasd ");
    }
}
