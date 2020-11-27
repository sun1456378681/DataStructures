package com.aituigu.java8;

import org.junit.Test;

import java.util.Comparator;


/**
 * xx类
 *
 * @author eric
 * @since 2020/11/4 11:16
 */
public class LambdaTest {

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
