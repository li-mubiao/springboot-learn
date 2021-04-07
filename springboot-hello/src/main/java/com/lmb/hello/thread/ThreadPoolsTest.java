package com.lmb.hello.thread;

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Copyright (C), 2021,
 * FileName: ThreadPoolsTest
 * Author:   mubiao0205@gmail.com
 * Date:     2021/3/14 下午2:28
 * Description: TODO
 * Version:1.0.0
 */
public class ThreadPoolsTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor(r->new Thread(r,"test"));
        executorService.execute(()-> {
            System.out.println(Thread.currentThread().getName());
            try {
                int i = 1/0;
            }catch (Exception e){
                System.out.println("error");
            }
        });
        executorService.execute(()-> System.out.println(Thread.currentThread().getName()));


    }

}