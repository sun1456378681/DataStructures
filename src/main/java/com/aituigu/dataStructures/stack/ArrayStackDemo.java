package com.aituigu.dataStructures.stack;

/**
 * @author aaa
 */
public class ArrayStackDemo {

}

class ArrayStack {
    // 栈的大小
    private int maxSize;
    // 数组，数组模拟栈，数据就放在该数组

    private int[] stack;
    // top表示栈顶 初始化为-1
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满！");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！");
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空！");
        }

        // 需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d \n", i, stack[i]);
        }
    }
}
