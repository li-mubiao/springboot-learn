package com.lmb.hello.proxy;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-09 18:09
 */
public class StaticProxyTest implements Subject {

    private RealSubject realSubject;

    public StaticProxyTest(RealSubject subject) {
        this.realSubject = subject;
    }


    @Override
    public void request() {
        // 执行代理逻辑
        System.out.println("卖房前");

        // 执行目标对象方法
        realSubject.request();

        // 执行代理逻辑
        System.out.println("卖房后");
    }

    @Override
    public void test() {

    }

    public static void main(String[] args) {
        // 被代理对象
        RealSubject subject = new RealSubject();

        // 代理
        StaticProxyTest proxy = new StaticProxyTest(subject);

        // 代理请求
        proxy.request();
    }
}