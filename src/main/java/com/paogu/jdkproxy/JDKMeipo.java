package com.paogu.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/19 9:43
 */
public class JDKMeipo implements InvocationHandler {

    //被代理的对象，把引用保存下来
    private Object target;

    public Object getInstance(Object target) throws Exception {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(this.target, args);
        return invoke;
    }
}
