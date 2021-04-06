package com.lmb.hello.functional;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-04-06 14:29
 */
public class Test {

    public static void main(String[] args) {
        HelloFunctional hello = param -> param + "world!";
        System.out.println("test functional:" + hello.say("hello,"));
    }
}