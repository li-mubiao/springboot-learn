package com.lmb.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (C), 2021,
 * FileName: VolatileTest1
 * Author:   mubiao0205@gmail.com
 * Date:     2021/3/11 下午10:42
 * Description: TODO
 * Version:1.0.0
 */
public class VolatileTest1 {





    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        SynchronizedTest synchronizedTest = new SynchronizedTest();
            for (int i = 0; i < 1000; i++) {
                executorService.submit(synchronizedTest);
            }
        int size = synchronizedTest.getList().size();
        System.out.println(size);
        executorService.shutdown();
    }
}

class SynchronizedTest implements Runnable{


    volatile int num = 0;
    volatile List<Integer> list =new ArrayList<>();
    @Override
    public synchronized  void run() {
        num ++;
        list.add(num);
    }
    public List<Integer> getList(){
        return list;
    }

}

