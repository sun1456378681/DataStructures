package com.aituigu.aop;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/7 10:08
 */
public class Calculator {

    public int div(int i, int j) {
        System.out.println("Calculator.div 执行。。。");
        return i / j;
    }
}
