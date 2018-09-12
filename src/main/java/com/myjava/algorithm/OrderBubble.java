package com.myjava.algorithm;

import java.util.Arrays;

/**冒泡排序 从最后以为开始排序
 * Created by flyap on 2018/4/12.
 */
public class OrderBubble {
//冒泡排序
    public static void  compare(Integer[] array){
        int temp=0;
        for (int k = 0; k<array.length-1; k++) {//
            //每轮循环中从最后一个元素开始向前起泡，直到i=k止，即i等于轮次止
            for (int i = array.length-1; i>k; i--) {
                 if(array[i].compareTo(array[i-1])<0){
                     temp = array[i];
                     array[i] = array[i - 1];
                     array[i - 1] = temp;
                 }
            }

        }

    }
private static void  swap(Integer[] array,int x,int y){
    if(x!=y){   //只有不是同一位置才进行交换
        int temp= array[x];
        array[x]=array[y];
        array[y]=temp;
}

}
}
