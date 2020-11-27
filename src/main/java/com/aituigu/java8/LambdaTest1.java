package com.aituigu.java8;

import org.junit.Test;

import java.util.Comparator;


/**
 * Lambda表达式的使用
 * 1。举例：（o1,o2） -> Integer.compare(o1,o2)
 * 2。格式：
 *      -> :lambda操作符 或 箭头操作符
 *      -> 左边: lambda形参列表（其实就是接口中的抽象方法的形参列表）
 *      -> 右边:
 * @author eric
 * @since 2020/11/4 11:16
 */
public class LambdaTest1 {

    @Test
    public static void test1() {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门！");
            }
        };
        r1.run();

        System.out.println("**************************************");

        Runnable r2 = () -> System.out.println("我爱北京故宫！");

        r2.run();
    }

    @Test
    public void test2() {

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };

        Comparator<Integer> com = (o1, o2) -> Integer.compare(o1, o2);
    }
}
