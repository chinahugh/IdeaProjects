package com.java.focus.innerclass;

import java.awt.*;

/**
 * @Author: hugh
 * @Time: 2018/02/11 8:59 PM
 * @Discraption: 内部类  成员内部类
 */
public class HelloWorldInnerClass {
    private Inner inner=new Inner();
    private String str="this String";

    private class Inner{

        private void disPlay() {
            System.out.println("this "+this);
            System.out.println(str);
            new Color(0xAF75EC);
        }

    }
    public static void main(String[] args) {
        HelloWorldInnerClass helloWorldInnerClass = new HelloWorldInnerClass();
        helloWorldInnerClass.inner.disPlay();
    }
}
