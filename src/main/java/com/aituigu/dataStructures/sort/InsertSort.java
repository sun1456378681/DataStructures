package com.aituigu.dataStructures.sort;

import java.util.Random;

/**
 * @author aaa
 */
public class InsertSort {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            // [0, 8000000)的数
            arr[i] = random.nextInt(8000000);
        }
        long l1 = System.currentTimeMillis();

        insertSort(arr);
        System.out.println("插入排序执行时间：" + (System.currentTimeMillis() - l1));

        long l2 = System.currentTimeMillis();
        selectSort(arr);
        System.out.println("选择排序执行时间：" + (System.currentTimeMillis() - l2));
    }

    // 选择排序
    public static void selectSort(int[] arr) {

        // 选择排序时间复杂度是O(n^2)
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    // 说明假定最小的值不是最小
                    min = arr[j];
                    // 重置min
                    minIndex = j;
                    // 重置minIndex
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }

    // 插入排序
    public static void insertSort(int[] arr) {
        // 使用逐步推导的方式来讲解，便于理解
        // 第一轮 {101, 34, 119, 1} => {34, 101, 119, 1}

        for (int i = 1; i < arr.length; i++) {
            // 定义待插入的数
            int insertVal = arr[i];
            // 即arr[1] 的前面这个数的下标
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            // 当退出while循环时，说明插入的位置找到，insetIndex + 1
            arr[insertIndex + 1] = insertVal;

//            System.out.println("第" + i + "轮插入");
//            System.out.println(Arrays.toString(arr));
        }


        //给insertIndex
    }
}


