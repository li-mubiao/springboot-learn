package com.lmb.hello.thread;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 11
 *
 * @author 李木标 limubiao@i72.com
 * @since 2020-10-08 10:21
 */
public class ThreadPoolTest {

    private static final int loopNum = 1 * 10;

    public static void main(String args[]) throws InterruptedException {



        AtomicInteger ctl = new AtomicInteger((-1 << 29)| 0);

        int i = ctl.get() & ((1 << 29) - 1);


        System.out.println(i);

        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
        ThreadFactory factory = r -> new Thread(r, "test-thread-pool");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.SECONDS, queue, factory, new ThreadPoolExecutor.CallerRunsPolicy());
        while (true) {
            executor.execute(() -> {
                try {
//                    System.out.println(queue.size());
                    System.out.println(Thread.currentThread().getName() + "==========" + "执行任务");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


//        long bt = System.currentTimeMillis();
//        List<String> list = new ArrayList<>();
//        list.add("0");
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.add("6");
//        list.add("7");
//        list.add("8");
//        list.add("9");
//        m1(list);
//        long et2 = System.currentTimeMillis();
//        System.out.println("[1]耗时:"+(et2 - bt)+ "ms");


    }

    public static void m1(List<String> list) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(list.get(i));
            pool.execute(() -> {
                try {
                    Thread.sleep(1000);
//                    模拟耗时操作
                    System.out.println("[1]" + Thread.currentThread().getName() + "----" + str);
//                    int j = 1/0;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxx");
        }
        System.out.println("[1] done!");
        pool.shutdown();
    }


}