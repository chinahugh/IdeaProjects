package com.java.focus.thread.example.demo2;

/**
 * @Auther HUGH
 * @Date 2018/6/7
 * @Description BankTest
 */
public class BankTest {
}

/**
 * 银行
 */
class Bank {
    private static int money;

    public Bank() {
    money=0;
    }
    public Bank(int money) {
        Bank.money=money;
    }

    /**
     * 取钱操作
     * @param sub
     * @return
     */
    public static int subtract(int sub){
        if (money<sub) {
            System.out.println("余额不足");
            return 0;
        }
        System.out.println("取出 "+sub);
        return money-sub;
    }

    /**
     * 存钱操作
     * @param add
     * @return
     */
    public static  int add(int add){
        return money+add;
    }

}
class Person{
    public int subtract(int sub){
        return Bank.subtract(sub);
    }
    public int add(int add){
        return Bank.add(add);
    }
}
