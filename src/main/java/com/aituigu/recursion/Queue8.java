package com.aituigu.recursion;

/**
 * @author aaa
 */
public class Queue8 {

    // 定义一个max表示有多少个皇后
    int max = 8;
    // 定义数组array，保存皇后放置位置的结果， 比如，arr = {0, 4, 7, 5, 2, 6, 1, 3}
    int[] array = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        int n = 1024;
        int i = 1;
        int count = 0;
        while (i < n) {
            count++;
            i = i * 2;
        }
        System.out.println(count);
//        // 测试 8皇后是否正确

//        Queue8 queue8 = new Queue8();
//        queue8.check(0);
//        System.out.printf("一共有%d种解法", count);
    }

    // 编写一个方法，放置第n个皇后
    // 特别注意：check是第一次递归时，进入到check中都有
    private void check(int n) {
        if (n == max) {
            print();
            return;
        }

        // 依次放入皇后，并判断冲突
        for (int i = 0; i < max; i++) {
            // 先把当前这个皇后n放到该行的第一列
            array[n] = i;
            if (judge(n)) {
                // 进来代表不冲突
                // 接着放n + 1 个皇后，即开始递归
                check(n + 1);
            }
            // 如果冲突，就继续执行array[n] = i; 即将第n个皇后放置在本行的后移的一个位置
        }
    }

    // 查看当我们放置第n个皇后，就去检测该皇后是否和以前已经摆放的皇后冲突
    private boolean judge(int n) {
        // 说明
        // 1. array[i] == array[n] 表示判断，第n个皇后是否和前面的n-1个皇后在同一列
        // 2. Math.abs(n - i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i个皇后是否在同一斜线
        //
        for (int i = 0; i < n; i++) {
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    // 写一个方法，将皇后摆放的位置打印出来
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
