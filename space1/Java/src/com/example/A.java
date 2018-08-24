package com.example;

/**
 * @Auther HUGH
 * @Date 2018/8/6
 * @Description A
 */
public class A {
    public void a(){
        System.out.println("A_a");
    }
    public void aa(){
        a();
        System.out.println("A_aa");
    }
}
