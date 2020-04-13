package com.lmb.hello;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Copyright (C), 2020,
 * FileName: MultiThread
 * Author:   mubiao0205@gmail.com
 * Date:     2020/4/9 21:42
 * Description: main线程包含的线程
 * Version:1.0.0
 */
public class MultiThread {

    public static void main(String[] args) {
        //获取Java线程管理MxBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //不需要获取同步的monitor和synchronize信息,仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            /**
             * [5]Monitor Ctrl-Break 监控线程
             * [4]Signal Dispatcher 分发处理发送给JVM信号的线程
             * [3]Finalizer 调用对象finalize的线程
             * [2]Reference Handler 清除 Reference的线程
             * [1]main 用户程序入口
             */
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }

    }

}