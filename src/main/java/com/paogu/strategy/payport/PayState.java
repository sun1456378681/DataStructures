package com.paogu.strategy.payport;

/**
 * 支付状态包装类
 *
 * @author eric
 * @since 2020/11/20 9:21
 */
public class PayState {
    private int code;
    private Object data;
    private String msg;

    public PayState(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "支付状态[" + code + "], " + msg + ", 交易详情：" + data;
    }
}
