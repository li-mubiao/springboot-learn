package com.lmb.hello;

/**
 * 静态代理
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-09 17:40
 */
public class Proxy implements Subject{

    private RealSubject realSubject;

    public Proxy(RealSubject subject) {
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

    public static void main(String[] args) {
        // 被代理对象
        RealSubject subject = new RealSubject();

        // 代理
        Proxy proxy = new Proxy(subject);

        // 代理请求
        proxy.request();
    }
}