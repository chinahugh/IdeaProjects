package com.algorithm.sequence;

import org.junit.Test;

/**
 * @Author: hugh
 * @Date: 17-11-27:下午12:24
 * @Description: 冒泡排序
 * 算法思想
 * 1 两两比较，如果后者比前者大则交换位置
 * 2 每遍历一圈最大的数就会冒到最后，则确定了本轮比较中的最大值放到最后不动
 * 3 循环1、2直至遍历完所有
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
            for (int j = 0; j < len - i ; j++) {
                if (array[i] < array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
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
        Bubble.sort(array, 1);
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

    private int[] array = {23, 11, 7, 29, 33, 59, 8, 20, 9, 3, 2, 6, 10, 44, 83, 28, 5, 1, 0, 36};

    /**
     * 冒泡排序：两两比较，大者交换位置，则每一圈比较最大的数就会冒到最后，循环直至遍历完所有
     */
    @Test
    public void bubbleSort() {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
