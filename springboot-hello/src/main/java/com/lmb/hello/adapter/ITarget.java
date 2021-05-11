package com.lmb.hello.adapter;

import java.lang.annotation.Target;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-05-11 11:11
 */
public interface ITarget {
    void f1();

    void f2();

    void fc();
}

class Adaptee {
    public void fa() {
        //...
    }

    public void fb() {
        //...
    }

    public void fc() {
        //...
    }
}

/**
 * 继承实现 类适配器
 */
class Adaptor extends Adaptee implements ITarget {

    @Override
    public void f1() {
        super.fa();
    }

    @Override
    public void f2() {
        super.fb();
    }
}

/**
 * 组合实现 对象适配器
 */
class Adaptor1 implements ITarget {

    private Adaptee adaptee;

    public Adaptor1(Adaptee adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public void f1() {
        adaptee.fa();
    }

    @Override
    public void f2() {
        adaptee.fb();
    }

    @Override
    public void fc() {
        adaptee.fc();
    }
}