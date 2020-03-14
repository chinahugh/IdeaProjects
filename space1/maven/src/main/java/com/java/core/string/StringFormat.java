package com.java.core.string;

import java.util.function.BiFunction;

/**
 * @Author: hugh
 * @Time: 2018/01/05 11:16 AM
 * @Discraption:
 */
public class StringFormat {
    public static void main(String[] args) {
        String a=FORMAT.apply("%05d", 9);
        System.out.println(a);
        String format = String.format("%-5d", -999999);
        System.out.println(format);

        new Thread(() -> System.out.println("ll")).start();
        System.out.println("[\\]");
    }



    private static final BiFunction<String, Integer, String> FORMAT = String::format;
}


