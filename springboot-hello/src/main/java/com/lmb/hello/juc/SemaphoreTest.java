package com.lmb.hello.juc;

import java.util.concurrent.Semaphore;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2020-11-06 11:41
 */
public class SemaphoreTest {
    private final static Semaphore permit = new Semaphore(5,true);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            test();
        }
    }

    public static void test(){
        try {
            permit.acquire(1);
            System.out.println("xxxxx");
            Thread.sleep(1000L);
//            int i =1/0;
//            System.out.println("XXXX");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            permit.release();
        }
    }
}