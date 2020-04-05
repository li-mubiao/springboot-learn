package com.lmb.hello;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Copyright (C), 2020,
 * FileName: DirectMemoryOOm
 * Author:   mubiao0205@gmail.com
 * Date:     2020/4/5 12:21
 * Description: 堆外内存溢出
 * VM args:-Xmx20M -XX:MaxDirectMemorySize=20m
 * Version:1.0.0
 */
public class DirectMemoryOOM {
    private static final int _1MB =1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);
        Unsafe unsafe = (Unsafe)declaredField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }


    }

}