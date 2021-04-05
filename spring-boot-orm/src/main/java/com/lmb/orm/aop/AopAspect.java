package com.lmb.orm.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-04-01 11:37
 */
@Aspect
@Component
public class AopAspect {

    @Pointcut("@annotation(com.lmb.orm.aop.AopCheck)")
    public void pointcut() {
    }

    @After("pointcut()")
    public void after(){
        System.out.println("After");

    }

    @Before("pointcut()")
    public void before(){

        System.out.println("Before");

    }


    @AfterReturning(value = "pointcut()",returning = "returnValue")
    public void afterReturning(Object returnValue){
        System.out.println("AfterReturning");

    }

    @AfterThrowing(value = "pointcut()",throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("AfterThrowing");
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("Around 前");
        Object proceed = joinPoint.proceed();
        System.out.println("Around 后");

    }
}