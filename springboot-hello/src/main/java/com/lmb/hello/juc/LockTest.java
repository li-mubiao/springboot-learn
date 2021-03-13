package com.lmb.hello.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright (C), 2021,
 * FileName: LockTest
 * Author:   mubiao0205@gmail.com
 * Date:     2021/3/11 下午11:33
 * Description: TODO
 * Version:1.0.0
 */
public class LockTest {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try {
            lock.lockInterruptibly();
            System.out.println(lock.isLocked());
        }catch (Exception e){
            lock.unlock();
        }
    }
}