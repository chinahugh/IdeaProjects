package com.java.audition.code;

import java.util.Scanner;

/**
 * @Auther HUGH
 * @Date 2018/7/25
 * @Description EquilibriumNumber 平衡数
 * 平衡数的定义是：将一个数分成左右两部分，分别成为两个新的数。
 * 左右部分必须满足以下两点：
 * 1，左边和右边至少存在一位。
 * 2，左边的数每一位相乘如果等于右边的数每一位相乘，则这个数称为平衡数。
 * 例如：1221这个数，分成12和21的话，1*2=2*1，则称1221为平衡数，再例如：1236这个数，可以分成123
 * 和1*2*3=6，所以1236也是平衡数。而1234无论怎样分也不满足平衡数。
 * 输入描述：
 * 输入一个正整数（int范围内）。
 * 输出描述：
 * 如果该数是平衡数，输出 "YES", 否则输出 "NO"。
 * 示例1:
 * 输入
 * 1221
 * 1234
 * 输出
 * YES
 * NO
 */
public class EquilibriumNumber {
    public static void main(String[] args) {
        long l = Math.round(11.5) + Math.round(-11.5);
        System.out.println(l);
        EquilibriumNumber equilibriumNumber = new EquilibriumNumber(2);
        equilibriumNumber.EquilibriumNumber(0);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请输入数字：");
            String num = scanner.next();
            try {
                Integer numm = new Integer(num);
                boolean is_equilibrium = equilibriumNumber.equilibriumNumber_1(numm);
                //boolean is_equilibrium = equilibriumNumber.equilibriumNumber_2(numm);
                System.out.println(num + " 是否为平衡数 " + is_equilibrium);
            } catch (NumberFormatException e) {
                System.out.println("输入有误，重新输入");
            }
        }

    }

    /**
     * 方式1 输入数字转为String再转为char[]操作
     *
     * @param number
     */
    public boolean equilibriumNumber_1(int number) {
        if (number < 11) {
            return false;
        }
        char[] chars = String.valueOf(number).toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (balance(chars, i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方式2 求模方式
     *
     * @param number
     * @return
     */
    public boolean equilibriumNumber_2(int number) {
        if (number < 11) {
            return false;
        }
        int num = number;
        int[] arr = new int[Integer.toString(number).length()];
        for (int i = Integer.toString(number).length() - 1; num > 9; i--) {
            arr[i] = num % 10;
            num = num / 10;
        }
        arr[0] = num;
        for (int i = 0; i < arr.length - 1; i++) {
            if (balance(arr, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean balance(char[] chars, int i) {
        int head = 1;
        int tail = 1;
        for (int j = 0; j < chars.length; j++) {
            int num = Integer.parseInt(String.valueOf(chars[j]));
            if (j <= i) {
                head = head * num;
            }
            if (j > i) {
                tail = tail * num;
            }
        }
        return head == tail;
    }

    private boolean balance(int[] ints, int i) {
        int head = 1;
        int tail = 1;
        for (int j = 0; j < ints.length; j++) {
            if (j <= i) {
                head = head * ints[j];
            }
            if (j > i) {
                tail = tail * ints[j];
            }
        }
        return head == tail;
    }
    public EquilibriumNumber EquilibriumNumber(int a){
return this;
    }
    public  EquilibriumNumber(int a){

    }
}
