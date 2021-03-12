package com.lmb.hello;

import org.aspectj.weaver.ast.Test;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-11 18:05
 */
public class RtLockTest {

    static  int value=0;
    static RtLock myLock=new RtLock();
    public  int getValue() {
        myLock.lock();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value ++;
        myLock.unLock();
        return value;
    }

    public void a() {
        myLock.lock();
        System.out.println("a");
        b();
        myLock.unLock();
    }

    public void b() {
        myLock.lock();
        System.out.println("b");
        myLock.unLock();
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread();
        t.start();
        t.start();

        RtLockTest rtLockTest = new RtLockTest();

        //检测是否会并发
        Runnable runnable = () -> {
            for (int i = 0; i<100; i++) {
                System.out.println(Thread.currentThread().getId()+",值：" + rtLockTest.getValue());
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        //检测重入锁
        Runnable runnable1 = () -> rtLockTest.a();
        new Thread(runnable1).start();
    }


}