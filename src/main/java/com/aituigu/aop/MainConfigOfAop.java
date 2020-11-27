package com.aituigu.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/7 9:25
 *
 * AOP原理：
 *      @EnableAspectJAutoProxy
 * 1、@EnableAspectJAutoProxy是什么？
 *      @Import(AspectJAutoProxyRegistrar.class) 给容器中导入AspectJAutoProxyRegistrar
 *      利用AspectJAutoProxyRegistrar自定义给容器中注册bean
 *      internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator
 *      给容器中注册一个AnnotationAwareAspectJAutoProxyCreator；
 * 2、AnnotationAwareAspectJAutoProxyCreator:
 *      AnnotationAwareAspectJAutoProxyCreator
 *          -> AspectJAwareAdvisorAutoProxyCreator
 *              -> AbstractAdvisorAutoProxyCreator
 *                  -> AbstractAutoProxyCreator
 *                          implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *                      关注后置处理器（在bean初始化完成前后做事情）、自动装配BeanFactory
 *
 *  AbstractAutoProxyCreator.setBeanFactory()
 *  AbstractAutoProxyCreator.有后置处理器的逻辑；
 *
 *  AbstractAdvisorAutoProxyCreator. 重写 setBeanFactory() -> initBeanFactory()
 *
 *  AnnotationAwareAspectJAutoProxyCreator. 重写 initBeanFactory()
 *
 *
 */

@EnableAspectJAutoProxy
public class MainConfigOfAop {

    @Bean
    public LogAspects getLogAspects(){
        return new LogAspects();
    }

    @Bean
    public Calculator getCalculator(){
        return new Calculator();
    }

}
