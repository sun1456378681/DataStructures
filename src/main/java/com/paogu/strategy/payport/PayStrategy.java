package com.paogu.strategy.payport;

import com.paogu.strategy.Payment;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付策略管理类
 *
 * @author eric
 * @since 2020/11/20 9:28
 */
public class PayStrategy {

    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "jdPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String DEFALT_PAY = ALI_PAY;

    private static Map<String, Payment> payStrategy = new HashMap<>();

    static {
        payStrategy.put(ALI_PAY, new AliPay());
        payStrategy.put(JD_PAY, new JDPay());
        payStrategy.put(UNION_PAY, new UnionPay());
        payStrategy.put(WECHAT_PAY, new WechatPay());
    }

    public static Payment get(String payKey) {
        if (!payStrategy.containsKey(payKey)) {
            return payStrategy.get(DEFALT_PAY);
        }
        return payStrategy.get(payKey);
    }
}
