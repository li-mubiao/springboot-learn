package com.lmb.hello;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Copyright (C), 2020,
 * FileName: IntegerDemo
 * Author:   mubiao0205@gmail.com
 * Date:     2020/3/29 12:53
 * Description: TODO
 * Version:1.0.0
 */
public class IntegerDemo {
    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal("1.0");
        int precision = bigDecimal.precision();
        System.out.println(bigDecimal);

        BigInteger i = new BigInteger(String.valueOf(Long.MAX_VALUE));
        System.out.println(i.add(BigInteger.ONE).toString());

        try {
            long l = i.add(BigInteger.ONE).longValueExact();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}