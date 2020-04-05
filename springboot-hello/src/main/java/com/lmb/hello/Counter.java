package com.lmb.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Copyright (C), 2020,
 * FileName: Counter
 * Author:   mubiao0205@gmail.com
 * Date:     2020/4/5 18:35
 * Description: 计算器实现
 * Version:1.0.0
 */
public class Counter {

    private AtomicInteger atomicI = new AtomicInteger(0);
    private int i =0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<Thread>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        cas.count();
                        cas.saleCount();
                    }
                }
            });
            ts.add(thread);

        }
        for (Thread t : ts) {
            t.start();
        }
        for (Thread t : ts) {
            try {
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
        System.out.println(System.currentTimeMillis()-start);
    }
    private void saleCount(){
        for (;;){
            int i = atomicI.get();
            boolean b = atomicI.compareAndSet(i, ++i);
            if(b){
                break;
            }
        }
    }

    private void count(){
        i++;
    }


}