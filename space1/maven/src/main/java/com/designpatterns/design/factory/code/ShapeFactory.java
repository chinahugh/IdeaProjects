package com.designpatterns.design.factory.code;

/**
 * @Auther HUGH
 * @Date 2018/4/25
 * @Description ShapeFactory
 */
public class ShapeFactory {
      final  static String  CIRCLE="CIRCLE";

    public Shape getShape(String type){
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        }
        if (type.equalsIgnoreCase("RECTANGLE")) {
            return new Circle();
        }
        if (type.equalsIgnoreCase("SQUARE")) {
            return new Circle();
        }
        return null;
    }
}
