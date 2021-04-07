package com.lmb.hello.juc;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2020-10-09 11:44
 */
@Slf4j
public class CountDownLatchMain {

    public static void main(String[] args) throws InterruptedException {
//        countDownLatchTest3();
//        countDownLatchTest2();
//        final CountDownLatch latch = new CountDownLatch(2);
//        System.out.println("主线程开始执行…… ……");
//        //第一个子线程执行
//        ExecutorService es1 = Executors.newSingleThreadExecutor();
//        es1.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                    System.out.println("子线程："+Thread.currentThread().getName()+"执行");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                latch.countDown();
//            }
//        });
//        es1.shutdown();
//
//        //第二个子线程执行
//        ExecutorService es2 = Executors.newSingleThreadExecutor();
//        es2.execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("子线程："+Thread.currentThread().getName()+"执行");
//                latch.countDown();
//            }
//        });
//        es2.shutdown();
//        System.out.println("等待两个线程执行完毕…… ……");
//        try {
//            latch.await();
//            System.err.println("看你什么时候执行");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("两个子线程都执行完毕，继续执行主线程");
        countDownLatchTest3();
//        final CountDownLatch latch = new CountDownLatch(2);
//
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
//                    Thread.sleep(3000);
//                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
//                    latch.countDown();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            };
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
//                    Thread.sleep(3000);
//                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
//                    latch.countDown();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            };
//        }.start();
//
//        try {
//            System.out.println("等待2个子线程执行完毕...");
//            latch.await();
//            System.out.println("2个子线程已经执行完毕");
//            System.out.println("继续执行主线程");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }


    private static void countDownLatchTest3()  {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        final CountDownLatch down = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            try {

                executorService.execute(() -> {

                    try {
                        System.out.println("线程:"+Thread.currentThread().getName()+"正在执行");
                        Thread.sleep(1000L);
                        System.out.println("线程:"+Thread.currentThread().getName()+"执行完毕");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        down.countDown();
                    }

                });
            } catch (Exception e) {
                log.error(e.getMessage());
            } finally {

            }
        }
        try {
            System.out.println("等待线程执行");
            down.await();
            System.out.println("线程执行完毕");

        } catch (Exception e) {

        } finally {
            executorService.shutdown();
        }
    }

    private static void countDownLatchTest2() {
        final CountDownLatch down = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    down.await();
                } catch (Exception e) {
                }
                SimpleDateFormat sdf = new SimpleDateFormat("yymmdd HH:mm:ss|SSS");
                String orderNo = sdf.format(new Date());
                System.err.println("生成的订单号是：" + orderNo);

            }).start();

        }

        down.countDown();

    }


    private static void countDownLatchTest() throws InterruptedException {
        ExecutorService exector = Executors.newFixedThreadPool(5);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int threadNum = list.size();
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        final AtomicLong atomicLong = new AtomicLong(threadNum);
        for (int i = 0; i < list.size(); i++) {
            final int threadID = i;
            exector.execute(
                    () -> {
                        try {
                            Thread.sleep(2000);
                            System.out.println(String.format("threadID:[%s] finished!!", threadID));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            countDownLatch.countDown();
                            atomicLong.incrementAndGet();
                        }
                    }
            );

        }

        countDownLatch.await();//保证之前的所有的线程都执行完成，才会走下面的
        System.out.println(countDownLatch.getCount());
        System.out.println("main thread finished!!");
        System.out.println("atomicLong" + atomicLong);
    }
}