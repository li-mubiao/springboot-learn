package com.lmb.hello.bridge;

/**
 * Copyright (C), 2021,
 * FileName: Coffee
 * Author:   mubiao0205@gmail.com
 * Date:     2021/5/10 23:06
 * Description: TODO
 * Version:1.0.0
 */
public abstract class Coffee {

    protected ICoffeeAdditives additives;

    public Coffee(ICoffeeAdditives additives){
        this.additives=additives;
    }
    public abstract void orderCoffee(int count);
}