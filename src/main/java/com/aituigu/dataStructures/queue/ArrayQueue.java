package com.aituigu.dataStructures.queue;

/**
 * @author aaa
 * 使用数组模拟队列
 */
public class ArrayQueue {
    // 表示数组的最大容量
    private int maxSize;
    // 队列头
    private int front;
    //队列尾
    private int rear;
    //该数据用户存放数据，模拟队列
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        // 指向队列头部，分区出front是指向队列头的前一个位置
        front = -1;
        // 指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
        rear = -1;
    }

    // 判断队列是否满
    private boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~~");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列空的，没有数据~~");
        }
        // front后移动
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue() {

        if (isEmpty()) {
            System.out.println("队列空的，没数据~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }
}
