package com.aituigu.dataStructures.queue.circle;

import java.util.Scanner;

/**
 * @author aaa
 */
public class CircleArrayQueueDemo {

    public static void main(String[] args) {

        //创建一个环形队列
        // 说明设置 4， 其队列的有效数据最大是3a
        CircleArray queue = new CircleArray(4);

        //接收用户输入
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
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


