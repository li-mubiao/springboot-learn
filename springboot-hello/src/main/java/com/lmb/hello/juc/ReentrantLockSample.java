package com.lmb.hello.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-12 16:46
 */
public class ReentrantLockSample{

    public static void main(String[] args) {

        ReentrantLock r1 = new ReentrantLock();
        ReentrantLock r2 = new ReentrantLock();

        Thread t1 = new Thread(() -> {
            r1.lock();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r2.lock();
        });
        Thread t2 = new Thread(() -> {
            r2.lock();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r1.lock();
        });
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(t1);
        executorService.submit(t2);
        executorService.shutdown();

    }
}