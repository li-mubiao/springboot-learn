package com.lmb.hello.bridge;

/**
 * Copyright (C), 2021,
 * FileName: Milk
 * Author:   mubiao0205@gmail.com
 * Date:     2021/5/10 23:08
 * Description: TODO
 * Version:1.0.0
 */
//加奶
public class Milk implements ICoffeeAdditives {
    @Override
    public void addSomething() {
        System.out.println("加奶");
    }
}