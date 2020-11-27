package com.aituigu.dataStructures.sort;

import java.util.Arrays;

/**
 * @author aaa
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // 使用逐步推导的方式来编写希尔排序
    public static void shellSort(int[] arr) {




        int temp = 0;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素（共五组，每组有两个元素），步长为5
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加步长后的那个元素
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
    }

    public static void shellSort2(int[] arr) {

        // 增量gap,并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的分组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        // 移动
                        arr[j] = arr[j -gap];
                        // j
                    }
                }
            }
        }
    }


    /**
     // 希尔排序的第一轮排序
     // 因为第一轮排序是将10个数据分成了5组
     for (int i = 5; i < arr.length; i++) {
     // 遍历各组中所有的元素（共五组，每组有两个元素），步长为5
     for (int j = i - 5; j >= 0; j -= 5) {
     // 如果当前元素大于加步长后的那个元素
     if (arr[j] > arr[j + 5]) {
     temp = arr[j];
     arr[j] = arr[j + 5];
     arr[j + 5] = temp;
     }
     }
     }

     // 希尔排序的第二轮排序
     // 因为第二轮排序，是将10个数据分成了两组，5/2 = 2
     for (int i = 2; i < arr.length; i++) {
     // 遍历各组中所有的元素（共五组，每组有两个元素），步长为5
     for (int j = i - 2; j >= 0; j -= 2) {
     // 如果当前元素大于加步长后的那个元素
     if (arr[j] > arr[j + 2]) {
     temp = arr[j];
     arr[j] = arr[j + 2];
     arr[j + 2] = temp;
     }
     }
     }

     // 希尔排序的第二轮排序
     // 因为第二轮排序，是将10个数据分成了两组，5/2 = 2
     for (int i = 1; i < arr.length; i++) {
     // 遍历各组中所有的元素（共五组，每组有两个元素），步长为5
     for (int j = i - 1; j >= 0; j -= 1) {
     // 如果当前元素大于加步长后的那个元素
     if (arr[j] > arr[j + 1]) {
     temp = arr[j];
     arr[j] = arr[j + 1];
     arr[j + 1] = temp;
     }
     }
     }
     */
}
