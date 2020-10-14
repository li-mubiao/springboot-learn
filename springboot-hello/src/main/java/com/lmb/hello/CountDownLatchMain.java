package com.lmb.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2020-10-09 11:44
 */
public class CountDownLatchMain {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exector = Executors.newFixedThreadPool(5);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int threadNum = list.size();
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < list.size(); i++) {
            final int threadID = i;
            exector.execute(
                    () -> {
                        try {
                            Thread.sleep(2000);
                            System.out.println(String.format("threadID:[%s] finished!!", threadID));
                            System.out.println(countDownLatch.getCount());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            countDownLatch.countDown();  //这个不管是否异常都需要数量减,否则会被堵塞无法结束
                        }
                    }
            );

        }
        countDownLatch.await();//保证之前的所有的线程都执行完成，才会走下面的
        System.out.println(countDownLatch.getCount());
        System.out.println("main thread finished!!");

    }
}