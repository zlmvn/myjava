package com.myjava.algorithm;

import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
		Integer[] arr={13,56,22,22,111,32};

		System.out.println(Arrays.toString(arr));
		InsertSort.sort(arr);
		System.out.println(Arrays.toString(arr));
		SelectionSort.sort(arr);
		System.out.println(Arrays.toString(arr));
		OrderBubble.compare(arr);
		System.out.println(Arrays.toString(arr));
	}
}
