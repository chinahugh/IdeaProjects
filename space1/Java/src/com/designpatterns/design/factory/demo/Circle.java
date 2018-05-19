package com.designpatterns.design.factory.demo;

/**
 * @Auther HUGH
 * @Date 2018/4/25
 * @Description Circle
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw");
    }
}
