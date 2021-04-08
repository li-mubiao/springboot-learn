package com.lmb.hello.oom;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-04-07 18:19
 */
public class StringConstantPoolTest {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = Lists.newArrayList();
        while (true) {
            String intern = String.valueOf(System.currentTimeMillis()).intern();
            list.add(intern);
        }
    }
}