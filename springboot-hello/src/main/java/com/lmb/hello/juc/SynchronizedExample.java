package com.lmb.hello.juc;

/**
 * Copyright (C), 2020,
 * FileName: FlagTest
 * Author:   mubiao0205@gmail.com
 * Date:     2020/4/5 19:39
 * Description: TODO
 * Version:1.0.0
 */
public class SynchronizedExample {
    int a = 0;
    boolean flag = false;

    public synchronized void writer() {
        a = 1;
        flag = true;
    }

    public synchronized void read() {
        if (flag) {
            int i = a;
        }
    }


}