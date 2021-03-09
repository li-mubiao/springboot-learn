package com.lmb.hello;

/**
 * 静态代理
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-09 17:39
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("卖房");
    }
}