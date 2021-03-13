package com.lmb.hello.juc;

/**
 * Copyright (C), 2021,
 * FileName: AbnormalSemaphoreSample
 * Author:   mubiao0205@gmail.com
 * Date:     2021/3/13 上午10:17
 * Description: TODO
 * Version:1.0.0
 */

import java.util.concurrent.Semaphore;
public class AbnormalSemaphoreSample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new MyWorker(semaphore));
            t.start();
        }
        System.out.println("Action...GO!");
        semaphore.release(5);
        System.out.println("Wait for permits off");
        while (semaphore.availablePermits()!=0) {
            Thread.sleep(100L);
        }
        System.out.println("Action...GO again!");
        semaphore.release(5);
    }
}
class MyWorker implements Runnable {
    private Semaphore semaphore;
    public MyWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }
    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println("Executed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
