package com.aituigu.dataStructures.stack;

/**
 * @author aaa
 */
public class Calculator {

    public static void main(String[] args) {
        String experssion = "30-2*6+2";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义需要的相关变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        // 开始
        while (true) {
            // 一次得到expression的每一个字符
            ch = experssion.substring(index, index + 1).charAt(0);
            // 判断
            if (operStack.isOper(ch)) {
                // 判断当前的符号栈是否为空
                if (operStack.isEmpty()) {
                    // 如果为空直接入栈
                    operStack.push(ch);
                } else {
                    //  如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop出两个数，
                    // 在从符号栈中pop出一个符号，进行运算，将得到结果入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        // 把运算结果入数栈
                        numStack.push(res);
                        // 然后将当前的操作符入符号栈
                        operStack.push(ch);
                    } else {
                        // 如果当前的符号优先级大于栈中的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                }
            } else {
                if (index == experssion.length() - 1) {
                    numStack.push(ch - 48);
                } else {
                    keepNum += ch;
                    if (operStack.isOper(experssion.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            // 让index + 1， 判断是否扫描到expression最后
            index++;
            if (index >= experssion.length()) {
                break;
            }
        }
        // 当表达式扫描完毕，就顺序的从数
        while (true) {
            // 如果符号栈为空，则计算到最后的结果，数栈中只有一个数字【结果】
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            if (!operStack.isEmpty()){
                int oper2 = operStack.peek();
                if (oper2 == '-') {
                    num2 = -num2;
                }
            }
            oper = '+';
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        // 将数栈的最后数，pop出，就是结果
        int res2 = numStack.pop();
        System.out.printf("表达式%s = %d", experssion, res2);
    }

}

class ArrayStack2 {
    // 栈的大小
    private int maxSize;
    // 数组，数组模拟栈，数据就放在该数组
    private int[] stack;
    // top表示栈顶 初始化为-1
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
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

    public int peek() {
        return stack[top];
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

    // 返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示
    // 数字越大，则优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}
