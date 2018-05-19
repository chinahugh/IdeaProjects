package com.designpatterns.design.factory.demo;

/**
 * @Auther HUGH
 * @Date 2018/4/25
 * @Description FactoryPatternDemo
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Square square= (Square) factory.getShape(ShapeFactory.CIRCLE);
        square.draw();
    }
}
