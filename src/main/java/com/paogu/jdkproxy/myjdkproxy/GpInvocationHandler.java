package com.paogu.jdkproxy.myjdkproxy;

import java.lang.reflect.Method;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/19 9:50
 */
public interface GpInvocationHandler {

    /**
     * invoke
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
