package com.lmb.hello;

/**
 * Copyright (C), 2020,
 * FileName: Precedence
 * Author:   mubiao0205@gmail.com
 * Date:     2020/3/29 12:16
 * Description: TODO
 * Version:1.0.0
 */
public class Precedence {

    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int a = x + y - 2 / 2 + z;//5
        int b = x + (y - 2) / (2 + z);//1
        System.out.println("a==" + a + "," + "b ==" + b);
    }

}