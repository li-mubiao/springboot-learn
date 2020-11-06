package com.lmb.hello;

import java.util.concurrent.Semaphore;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2020-11-06 11:41
 */
public class SemaphoreTest {
    private final static Semaphore permit = new Semaphore(1,true);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            test();
        }
    }

    public static void test(){
        try {
            permit.acquire();
            System.out.println("xxxxx");
//            int i =1/0;
//            System.out.println("XXXX");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            permit.release();
        }
    }
}