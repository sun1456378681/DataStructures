package com.aituigu.queue.circle;

/**
 * @author aaa
 * 使用数组模拟队列
 */
public class CircleArray {
    // 表示数组的最大容量
    private int maxSize;
    // front 变量的含义做一个调整：front 就指向队列的第一个元素，也就是队列的第一个元素 front的初始值 = 0
    private int front;
    // rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置，因为希望空出一行 rear 的初始值 = 0
    private int rear;
    //该数据用户存放数据，模拟队列
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    private boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
        System.out.println(rear);
    }

    // 获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列空的，没有数据~~");
        }
        // 需要分析出front是指向队列的第一个元素
        // 1. 先把front 对应的值保存到一个临时变量
        // 2. 将front后移
        // 3. 将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        System.out.println(front);
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {

        if (isEmpty()) {
            System.out.println("队列空的，没数据~~");
            return;
        }
        // 思路：从front开始遍历，遍历多少元素
        // 动脑筋
        for (int i = front; i < front + size(); i++) {
            int index = i % maxSize;
            System.out.printf("arr[%d]=%d\n", index, arr[index]);
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        // rear = 2
        // front = 1s
        // maxSize = 3
        int i = (rear + maxSize - front) % maxSize;
        System.out.println("队列有效数据：" + i);
        return i;
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front];
    }
}
