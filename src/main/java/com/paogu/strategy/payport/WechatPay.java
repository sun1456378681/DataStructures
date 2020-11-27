package com.paogu.strategy.payport;

import com.paogu.strategy.Payment;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/20 9:25
 */
public class WechatPay extends Payment {

    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected double queryBalance(String uid) {
        return 256;
    }
}
