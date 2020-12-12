package com.designpatterns.design.factory.code;

/**
 * @Auther HUGH
 * @Date 2018/4/25
 * @Description Square
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square.draw");
    }
}
