package com.paogu.strategy.payport;

import com.paogu.strategy.Payment;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/20 9:26
 */
public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "银联支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 120;
    }
}
