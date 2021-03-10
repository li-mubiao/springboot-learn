package com.lmb.hello.proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-09 17:05
 */
@Aspect
@Component
public class TestAdvice {

    // 1. 定义 PointCut
    @Pointcut("execution(* com.lmb.hello.proxy.TestServiceImpl.eatCarrot())")
    private void eatCarrot() {
    }

    // 2. 定义应用于 JoinPoint 中所有满足 PointCut 条件的 advice, 这里我们使用 around advice，在其中织入增强逻辑
    @Around("eatCarrot()")
    public void handlerRpcResult(ProceedingJoinPoint point) throws Throwable {
        System.out.println("吃萝卜前洗手");
        //  原来的 TestServiceImpl.eatCarrot 逻辑，可视情况决定是否执行
        point.proceed();
        System.out.println("吃萝后买单");
    }
}