package com.lmb.hello;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-08 21:57
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
//        int N = 4;
//        CyclicBarrier barrier = new CyclicBarrier(N);
//        for (int i = 0; i < N; i++) {
//            new Writer(barrier).start();
//        }
        ClassLoader classLoader = CyclicBarrierTest.class.getClassLoader();
        System.out.println(classLoader);
    }
}

class Writer extends Thread {
    private CyclicBarrier cyclicBarrier;

    public Writer(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
        try {
            //以睡眠来模拟写入数据操作
            Thread.sleep(5000);
            System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程写入完毕，继续处理其他任务...");
    }
}