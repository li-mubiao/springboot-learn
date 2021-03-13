package com.lmb.hello.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-11 16:49
 */
public class BarrierTest {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(1,()-> System.out.println("gogogo"));  //①
        Runner runner1 = new Runner(barrier, "张三");
        Runner runner2 = new Runner(barrier, "李四");
        Runner runner3 = new Runner(barrier, "王五");
        int numberWaiting = barrier.getNumberWaiting();
        System.out.println(numberWaiting);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(runner1);
        service.execute(runner2);
        service.execute(runner3);

        service.shutdown();

    }
}

class Runner implements Runnable{

    private CyclicBarrier barrier;
    private String name;

    public Runner(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            //模拟准备耗时
            Thread.sleep(new Random().nextInt(5000));
            System.out.println(name + ":准备OK");
            barrier.await();
            System.out.println(name +": 开跑");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}