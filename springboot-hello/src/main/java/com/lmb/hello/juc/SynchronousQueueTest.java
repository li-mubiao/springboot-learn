package com.lmb.hello.juc;

import java.util.concurrent.SynchronousQueue;

/**
 * 生产者消费者的实例
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-08 11:11
 */
public class SynchronousQueueTest {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        Thread putThread = new Thread(() -> {
            System.out.println("put thread start");
            try {
                queue.put(1);
                queue.put(2);
            } catch (InterruptedException e) {

            }
            Thread.State state = Thread.currentThread().getState();
            System.out.println(Thread.currentThread().getName()+state);
            System.out.println("put thread end");
        });

        Thread taskThread = new Thread(() -> {
            System.out.println("take thread start");
            try {
                System.out.println("take from putThread: " + queue.take());
            } catch (InterruptedException e) {
            }
            System.out.println(Thread.currentThread().getName()+Thread.currentThread().getState());
            System.out.println(queue);
            System.out.println("take thread end");

        });
        putThread.start();
        Thread.sleep(1000L);
        taskThread.start();
    }
}