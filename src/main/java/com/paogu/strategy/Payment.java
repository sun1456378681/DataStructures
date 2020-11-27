package com.paogu.strategy;

import com.paogu.strategy.payport.PayState;

/**
 * 支付抽象类， 定义支付规范和支付逻辑
 *
 * @author eric
 * @since 2020/11/20 9:18
 */
public abstract class Payment {

    /**
     * 支付类型
     *
     * @return
     */
    public abstract String getName();

    /**
     * 查询余额
     *
     * @param uid
     * @return
     */
    protected abstract double queryBalance(String uid);

    /**
     * 扣款顺序
     *
     * @param uid
     * @param amount
     * @return
     */
    public PayState pay(String uid, double amount) {
        if (queryBalance(uid) < amount) {
            return new PayState(500, "支付失败", "余额不足");
        }
        return new PayState(200, "支付成功", "支付金额：" + amount);
    }
}
