package com.lmb.hello;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-08 14:21
 */
public class VolatileTest {


    public static void main(String[] args) {

        Aobing aobing = new Aobing();
        aobing.start();
        for (; ; ) {
//            System.out.println(Thread.currentThread().getName());
//            synchronized (aobing) {
                if (aobing.isFlag()) {
                    System.out.println("xxxxx");
                }
//            }
        }
    }
}

class Aobing extends Thread {
    private volatile boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag ==== " + flag);
        System.out.println("flag ==== "+Thread.currentThread().getName());
    }
}