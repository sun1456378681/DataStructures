package com.aituigu.dataStructures.queue;

import java.util.Scanner;

/**
 * @author aaa
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {

        ArrayQueue queue = new ArrayQueue(3);

        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 推出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    int res1 = queue.getQueue();
                    System.out.printf("取出的数据是%d\n", res1);
                    break;
                case 'h':
                    int res2 = queue.headQueue();
                    System.out.printf("队列头的数据是%d\n", res2);
                    break;
                case 'e':
                    scanner.close();
                    break;
                default:
                    break;
            }
        }
    }


}


