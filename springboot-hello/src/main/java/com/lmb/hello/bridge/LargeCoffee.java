package com.lmb.hello.bridge;

/**
 * Copyright (C), 2021,
 * FileName: LargeCoffee
 * Author:   mubiao0205@gmail.com
 * Date:     2021/5/10 23:09
 * Description: TODO
 * Version:1.0.0
 */
public class LargeCoffee extends RefinedCoffee{

    public LargeCoffee(ICoffeeAdditives additives) {
        super(additives);
    }
    @Override
    public void orderCoffee(int count) {
        additives.addSomething();
        System.out.println("大杯咖啡" + count + "杯");
    }
}