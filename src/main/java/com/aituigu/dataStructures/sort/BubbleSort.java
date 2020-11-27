package com.aituigu.dataStructures.sort;

/**
 * @author aaa
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2};

        // 第一躺排序，就是将最大的数排到最后
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            // 如果前面的数据比后边的大，则交换
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
    }
}
