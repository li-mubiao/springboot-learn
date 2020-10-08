package com.lmb.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 11
 *
 * @author 李木标 limubiao@i72.com
 * @since 2020-10-08 10:21
 */
public class ThreadPoolTest{

    private static final int loopNum = 1*10;

    public static void main(String args[]) throws InterruptedException {

        long bt = System.currentTimeMillis();
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        m1(list);
        long et2 = System.currentTimeMillis();
        System.out.println("[1]耗时:"+(et2 - bt)+ "ms");


    }

    public static void m1( List<String> list) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            System.out.println(list.get(i));
            pool.execute(() -> {
                    try {
                        Thread.sleep(1000);
//                    模拟耗时操作
                        System.out.println("[1]" + Thread.currentThread().getName()+"----"+str);
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