package com.lmb.hello.bridge;

import java.util.Random;

/**
 * Copyright (C), 2021,
 * FileName: RefinedCoffee
 * Author:   mubiao0205@gmail.com
 * Date:     2021/5/10 23:07
 * Description: TODO
 * Version:1.0.0
 */
public abstract class RefinedCoffee extends Coffee{
    public RefinedCoffee(ICoffeeAdditives additives) {
        super(additives);
    }
    public void checkQuality(){
        Random ran=new Random();
        System.out.println(String.format("%s 添加%s",additives.getClass().getSimpleName(),ran.nextBoolean()?"太多":"正常"));
    }
}