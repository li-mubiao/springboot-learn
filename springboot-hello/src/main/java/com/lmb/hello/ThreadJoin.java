package com.lmb.hello;

/**
 * Copyright (C), 2020,
 * FileName: ThreadState
 * Author:   mubiao0205@gmail.com
 * Date:     2020/4/9 22:04
 * Description: 线程状态
 * Version:1.0.0
 */
public class ThreadJoin{

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
//        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+"terminate . ");
    }
    static class Domino implements Runnable{

        private Thread thread;

        public Domino(Thread thread){
            this.thread=thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"terminate . ");
        }
    }

}