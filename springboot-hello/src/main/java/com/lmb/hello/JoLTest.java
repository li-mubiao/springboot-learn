package com.lmb.hello;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-04-08 10:16
 */
public class JoLTest {


    public static void weightLock() throws InterruptedException {
        Thread.sleep(5000);
        A a = new A();
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread1 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    try {
                        //让线程晚点儿死亡，造成锁的竞争
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread2 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }

    public static void lightLock() throws InterruptedException {
        Thread.sleep(5000);
        A a = new A();

        Thread thread1= new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("thread1 locking");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable()); //偏向锁
                }
            }
        };
        thread1.start();
        thread1.join();
        Thread.sleep(10000);

        synchronized (a){
            System.out.println("main locking");
            System.out.println(ClassLayout.parseInstance(a).toPrintable());//轻量锁
        }
    }


    public static void main(String[] args) throws InterruptedException {
//        weightLock();
//        weightLock();
    }
}

class ALock {
    boolean flag = false;
}