package com.paogu.strategy.payport;

import com.paogu.strategy.Payment;

/**
 * 创建具体的支付方式，此方式为支付宝
 *
 * @author eric
 * @since 2020/11/20 9:24
 */
public class AliPay extends Payment {
    @Override
    public String getName() {
        return "支付宝";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
