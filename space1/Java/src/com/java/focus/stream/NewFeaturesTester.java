package com.java.focus.stream;

/**
 * @Author: hugh
 * @Time: 2017/12/25 12:52 PM
 * @Discraption: lambda表达式
 */
public class NewFeaturesTester {
    public static void main(String args[]) {
        NewFeaturesTester tester = new NewFeaturesTester();

        // 带有类型声明的表达式
        MathOperation addition = (int a, int b) -> a + b;

        // 没有类型声明的表达式
        MathOperation subtraction = (a, b) -> a - b;

        // 带有大括号、带有返回语句的表达式
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号和return语句的表达式
        MathOperation division = (int a, int b) -> a / b;

        // 输出结果
        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 没有括号的表达式
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 有括号的表达式
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        // 调用sayMessage方法输出结果
        greetService1.sayMessage("Shiyanlou");
        greetService2.sayMessage("Classmate");
    }

    // 下面是定义的一些接口和方法

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}

/**
 * 接口	描述
 * BitConsumer	该接口代表了接收两个输入参数T、U，并且没有返回的操作
 * BiFunction	该接口代表提供接收两个参数T、U，并且产生一个结果R的方法
 * BinaryOperator	代表了基于两个相同类型的操作数，产生仍然是相同类型结果的操作
 * BiPredicate	代表了对两个参数的断言操作（基于Boolean值的方法）
 * BooleanSupplier	代表了一个给出Boolean值结果的方法
 * Consumer	代表了接受单一输入参数并且没有返回值的操作
 * DoubleBinaryOperator	代表了基于两个Double类型操作数的操作，并且返回一个Double类型的返回值
 * DoubleConsumer	代表了一个接受单个Double类型的参数并且没有返回的操作
 * DoubleFunction	代表了一个接受Double类型参数并且返回结果的方法
 * DoublePredicate	代表了对一个Double类型的参数的断言操作
 * DoubleSupplier	代表了一个给出Double类型值的方法
 * DoubleToIntFunction	代表了接受单个Double类型参数但返回Int类型结果的方法
 * DoubleToLongFunction	代表了接受单个Double类型参数但返回Long类型结果的方法
 * DoubleUnaryOperator	代表了基于单个Double类型操作数且产生Double类型结果的操作
 * Function	代表了接受一个参数并且产生一个结果的方法
 * IntBinaryOperator	代表了对两个Int类型操作数的操作，并且产生一个Int类型的结果
 * IntConsumer	代表了接受单个Int类型参数的操作，没有返回结果
 * IntFunction	代表了接受Int类型参数并且给出返回值的方法
 * IntPredicate	代表了对单个Int类型参数的断言操作
 */

