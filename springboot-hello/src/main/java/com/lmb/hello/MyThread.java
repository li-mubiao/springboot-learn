package com.lmb.hello;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-02-23 17:23
 */
public class MyThread implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+"在运行");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t = new Thread(myThread, "线程");
        t.setDaemon(true);
        t.start();
        while (true){
            System.out.println();
        }

    }
}