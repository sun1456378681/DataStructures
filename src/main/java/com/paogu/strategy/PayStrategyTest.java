package com.paogu.strategy;

import com.paogu.strategy.payport.PayStrategy;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/20 9:49
 */
public class PayStrategyTest {

    public static void main(String[] args) {

        Order order = new Order("1", System.currentTimeMillis() + "", 3324.45);

        System.out.println(order.pay(PayStrategy.ALI_PAY));
    }
}
