package com.lmb.hello.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-09 18:10
 */
public class ProxyFactory {

    /**
     * 维护一个目标对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 为目标对象生成代理对象
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("计算开始时间");
                    // 执行目标对象方法
                    method = target.getClass().getMethod("request");
                    method.invoke(target, args);
                    System.out.println("计算结束时间");
                    return target.getClass().newInstance();
                });
    }


    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        System.out.println(realSubject.getClass());
        Subject subject = (Subject) new ProxyFactory(realSubject).getProxyInstance();
        System.out.println(subject.getClass());
        subject.test();
    }

}