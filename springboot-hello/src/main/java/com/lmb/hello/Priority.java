package com.lmb.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2020,
 * FileName: Priority
 * Author:   mubiao0205@gmail.com
 * Date:     2020/4/9 21:54
 * Description: 线程优先级
 * Version:1.0.0
 */
public class Priority {

    private static volatile boolean notStart = true;

    private static volatile boolean notEnd = true;

    public static void main(String[] args) throws InterruptedException {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int priority = i < 5 ? Thread.MIN_PRIORITY : Thread.MAX_PRIORITY;
            Job job = new Job(priority);
            jobs.add(job);
            Thread thread = new Thread(job, "Thread" + i);
            thread.setPriority(priority);
            thread.start();
        }
        notStart = false;
        TimeUnit.SECONDS.sleep(100);
        notEnd = false;
        for (Job job : jobs) {
            System.out.println("Job Priority : " + job.priority + " count :" + job.jobCount);
        }
    }

    static class Job implements Runnable {

        private int priority;

        private long jobCount;

        public Job(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            while (notStart) {
                Thread.yield();
            }
            while (notEnd) {
                Thread.yield();
                jobCount++;
            }
        }
    }
}