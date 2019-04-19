package com.java.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author HUGH
 * @Date 2019/4/19 20:56
 * @Description RemotApp 远程调试程序实例
 */
public class RemotApp {
    private static Logger logger = LoggerFactory.getLogger(RemotApp.class);
    private static int i = 0;

    public static void main(String[] args) {
        while (true) {
            logger.info("step into " + i++);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
