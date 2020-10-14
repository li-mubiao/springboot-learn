package com.lmb.hello;

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
public class CountDownLatchMain {

    public static void main(String[] args) throws InterruptedException {
//        countDownLatchTest();
        countDownLatchTest2();
    }

    private static void countDownLatchTest2() {
        final CountDownLatch down = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {

                        down.await();

                    } catch (Exception e) {

                    }

                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");

                    String orderNo = sdf.format(new Date());

                    System.err.println("生成的订单号是：" + orderNo);

                }

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