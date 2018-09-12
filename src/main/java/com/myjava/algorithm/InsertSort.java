package com.myjava.algorithm;

import java.util.Collections;

/**  1、数组的第二个元素作为交换元素和第一个比如果第二个小于第一个交换
 * 2、第三个元(作为插入对象)素和第二个比较如果小于前一个把值后移动 然后再用插入对象和前一个比如果小交换
 *
 */
public class InsertSort {
    public static void sort(Integer[] a) {
        int i, j, temp;// 要插入的数据
        for (i = 1; i < a.length; i++) {// 从数组的第二个元素开始循环将数组中的元素插入
            temp = a[i];// 设置数组中的第2个元素为第一次循环要插入的数据
            j = i - 1;
            while (j >= 0 && temp < a[j]) {
                a[j + 1] = a[j];// 如果要插入的元素小于第j个元素,就将第j个元素向后移动
                j--;
            }
            a[j + 1] = temp;// 直到要插入的元素不小于第j个元素,将insertNote插入到数组中
        }
    }
}