package com.java.audition.code;

import org.junit.Test;

import java.util.Scanner;

/**
 * @Auther HUGH
 * @Date 2018/6/21
 * @Description DeleteMostChar 替换输入的字符串中最多的字符串
 */
public class DeleteMostChar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String point = s.nextLine();
        System.out.println("删除前字符串为：" + str);
//        str = deleteMostChar(str, point);
        str = deleteletter(str, point);
        System.out.println("删除后字符串为：" + str);
        System.out.println(Character.forDigit(1, 1));
    }

    public static String deleteMostChar(String str, String point) {
        if (str != null && str.length() > 0) {
            char[] chars = str.toCharArray();
            int[] asciis = new int[256];
            //count
            int maxIndexAndChar = 1;
            //out char
            char index = chars[0];
            for (int i = 1; i < chars.length; i++) {
                asciis[chars[i]]++;
                if (asciis[chars[i]] > maxIndexAndChar) {
                    maxIndexAndChar = asciis[chars[i]];
                    index = chars[i];
                }
            }
            if (index == chars[0] && maxIndexAndChar == 1) {
                return str;
            }
            return str.replaceAll(String.valueOf(index), point);
        }
        return str;
    }

    @Test
    public void test() {
        System.out.println(Character.forDigit(10, 100));
    }

    @Test
    public void ASCII() {
        for (int i = 0; i < 25600; i++) {
            System.out.print(i + ":" + ((char) i) + " ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }

    @Test
    public void deleteletterTest() {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        String point = s.nextLine();
        System.out.println("删除前字符串为：" + str);
        //str = deleteletter(str, point);
        System.out.println("删除后字符串为：" + str);
        System.out.println(Character.forDigit(1, 1));
    }

    private static String deleteletter(String str, String point) {
        if (str != null && str.length() > 0) {
            char[] chars = str.toCharArray();
            int[] ints = new int[255];
            int count = Integer.MAX_VALUE;
            int count2 = Integer.MAX_VALUE;
            char out = chars[0];
            for (char c : chars) {
                ints[c]++;
                if (ints[c] <= count) {
                    count2 = count;
                    count = ints[c];
                    out = c;
                }
            }
            if (count == 1 && count2 == Integer.MAX_VALUE) {
                return str;
            }
            return str.replaceAll(String.valueOf(out), point);
        }
        return str;
    }
}
