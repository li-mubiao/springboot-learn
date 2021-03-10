package com.lmb.hello.proxy1;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Copyright (C), 2021,
 * FileName: MyMethodInterceptor
 * Author:   mubiao0205@gmail.com
 * Date:     2021/3/9 下午11:36
 * Description: TODO
 * Version:1.0.0
 */
public class MyMethodInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o,
                            Method method,
                            Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("目标类增强前！！！");
        //注意这里的方法调用，不是用反射哦！！！
        Object object = proxy.invokeSuper(o, args);
        System.out.println("目标类增强后！！！");
        return object;
    }
}

/** 生成的动态代理类（简化版）**/
class RealSubject$$EnhancerByCGLIB$$889898c5 extends RealSubject {
    @Override
    public void request() {
        System.out.println("增强前");
        super.request();
        System.out.println("增强后");
    }
}