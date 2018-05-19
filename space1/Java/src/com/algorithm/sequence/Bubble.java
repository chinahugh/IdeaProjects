package com.algorithm.sequence;

import org.junit.Test;

/**
 * @Author: hugh
 * @Date: 17-11-27:下午12:24
 * @Description: 冒泡排序
 */
public class Bubble {
    /**
     * [sort description] 冒泡排序实现
     *
     * @param array  [description]
     * @param choose [description] 1 顺序 0 倒序
     */
    public static void sort(int[] array, int choose) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (array[i] < array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;

                    display(array);
                }
            }
        }
    }

    /**
     * 测试方法
     */
    @Test
    public void test() {
        int[] ints = {1, 4, 6, 7, 34, 7, 8, 3, 5, 4, 6, 324, 6, 213, 56};
        System.out.print("原数组：");
        display(ints);
        Bubble.sort(ints, 1);
        System.out.print("排序后的数组：");
        display(ints);
    }

    /**
     * [display description] 打印数组
     *
     * @param ints [description]
     */
    private static void display(int[] ints) {
        for (int a : ints) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
