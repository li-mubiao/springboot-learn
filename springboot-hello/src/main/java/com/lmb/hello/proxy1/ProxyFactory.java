package com.lmb.hello.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Copyright (C), 2021,
 * FileName: ProxyFactory
 * Author:   mubiao0205@gmail.com
 * Date:     2021/3/9 下午11:25
 * Description: TODO
 * Version:1.0.0
 */
public class ProxyFactory {

    /**
     * 目标对象
     */
    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    /**
     * 生成代理对象
     * @param
     */

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("计算开始时间");
                // 执行目标对象方法
                method.invoke(target, args);
                System.out.println("计算结束时间");
                return null;
            }
        });
    }

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        System.out.println(realSubject.getClass());
        Subject subject = (Subject) new ProxyFactory(realSubject).getProxyInstance();
        System.out.println("==="+subject.getClass());
        subject.request();
    }

}