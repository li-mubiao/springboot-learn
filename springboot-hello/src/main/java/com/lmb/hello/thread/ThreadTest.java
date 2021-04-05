package com.lmb.hello.thread;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-04-02 11:42
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(() -> {
            try {
                Thread.sleep(4000L);
                System.out.println(Thread.currentThread()+"A");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread B = new Thread(() -> {
            try {
                Thread.sleep(4000L);
                System.out.println(Thread.currentThread()+"B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread.currentThread().join(5000L);
        System.out.println("123");
        A.start();
        B.start();






    }
}