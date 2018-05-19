package com.designpatterns.design.factory.demo;

/**
 * @Auther HUGH
 * @Date 2018/4/25
 * @Description Rectangle
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle.draw");
    }
}
