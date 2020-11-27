package com.aituigu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * xx类
 *
 * @author eric
 * @since 2020/11/7 9:24
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int com.aituigu.aop.Calculator.div(..))")
    public void piontCut() {

    }

    @Before("piontCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + "运行。。。@Before：参数是：{" + Arrays.asList(args) + "}");
    }

    @After("piontCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "结束。。。@After");
    }

    @AfterReturning(value = "piontCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "正常返回。。。@AfterReturning：运行结果是：{" + result + "}");
    }

    @AfterThrowing(value = "piontCut()", throwing = "exception")
    public void logReturn(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() + "异常。。。异常信息：{" + exception + "}");
    }
}
