package com.lmb.hello.bridge;

/**
 * Copyright (C), 2021,
 * FileName: BridgeMain
 * Author:   mubiao0205@gmail.com
 * Date:     2021/5/10 23:09
 * Description: TODO
 * Version:1.0.0
 */
public class BridgeMain {
    public static void main(String[] args) {
        //点两杯加奶的大杯咖啡
        RefinedCoffee largeWithMilk=new LargeCoffee(new Milk());
        largeWithMilk.orderCoffee(2);
        largeWithMilk.checkQuality();
    }

}