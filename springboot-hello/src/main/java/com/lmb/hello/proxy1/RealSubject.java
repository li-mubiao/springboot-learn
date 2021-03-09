package com.lmb.hello.proxy1;

/**
 * Copyright (C), 2021,
 * FileName: RealSubject
 * Author:   mubiao0205@gmail.com
 * Date:     2021/3/9 下午11:23
 * Description: TODO
 * Version:1.0.0
 */
public class RealSubject implements Subject{

    @Override
    public void request() {
        System.out.println("干饭人");
    }

}