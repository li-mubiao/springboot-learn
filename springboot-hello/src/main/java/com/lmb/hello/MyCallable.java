package com.lmb.hello;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-02-24 15:42
 */
public class MyCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<List<String>> listFutureTask = new FutureTask<>(()-> Lists.newArrayList("x","xxx","xxxx"));
        Thread thread = new Thread(listFutureTask);
        thread.start();
        List<String> list = listFutureTask.get();

        System.out.println(list);
    }
}