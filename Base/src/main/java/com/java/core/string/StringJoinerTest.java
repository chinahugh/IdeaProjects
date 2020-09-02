package com.java.core.string;

import java.util.StringJoiner;

public class StringJoinerTest {
    public void a() {

        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred");
        String desiredString = sj.toString();
        System.out.println(desiredString);
        System.out.println(sj.length());
    }

    public static void main(String[] args) {
        StringJoinerTest joiner = new StringJoinerTest();
        joiner.a();
    }
}
