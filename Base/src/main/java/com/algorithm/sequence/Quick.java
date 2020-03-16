package com.algorithm.sequence;

/**
 * @Author: hugh
 * @Date: 17-11-27:下午12:52
 * @Description: 快速排序
 */
public class Quick {
    /**
     * [quick description] 快速排序
     *
     * @param array [description]
     * @param left  [description]
     * @param right [description]
     */
    private static void quick(int[] array, int left, int right) {

        //如果left不小于right，需要排序的只有一个元素，无需排序
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        //设置最左边的元素为基准点
        int key = array[left];
        //把数组中大于key的排到key的右边，小的排左边
        while (i < j) {
            //j向左移动，直到找到一个小于key的数为止
            while (array[j] >= key && i < j) {
                j--;
            }
            //i向左移动，直到找到一个大于key的数为止
            while (array[i] <= key && i < j) {
                i++;
            }
            if (array[i] >= array[j] && i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        array[left] = array[i];
        array[i] = key;

        quick(array, left, i - 1);
        quick(array, i + 1, right);
    }

    /**
     * [_quick description]倒序数组
     *
     * @param array [description]
     */
    private static void _quick(int[] array) {
        quick(array, 0, array.length - 1);
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++;
            j--;
        }
    }

    /**
     * [quick description]
     *
     * @param array [description]
     * @param boo   [description] ture 小到大，false 大到小
     */
    public static void quick(int[] array, boolean boo) {
        if (boo) {
            quick(array, 0, array.length - 1);
        } else {
            _quick(array);
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 4, 6, 7, 34, 7, 8, 3, 5, 4, 6, 324, 6, 213, 56};
        System.out.print("原数组：");
        display(ints);
        quick(ints, false);
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
