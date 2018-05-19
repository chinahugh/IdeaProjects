package com.java.core.string;

import java.util.function.BiFunction;

/**
 * @Author: hugh
 * @Time: 2018/01/05 11:16 AM
 * @Discraption:
 */
public class StringFormat {
    public static void main(String[] args) {
        String a=test1.apply("%05d", 9);

//        String format = String.format("%05d", 9);
        System.out.println(a);

        new Thread(() -> System.out.println("ll")).start();
        System.out.println("[\\]");
    }



    private static BiFunction<String, Integer, String> test1 = String::format;
}


