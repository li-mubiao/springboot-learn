package com.lmb.hello.adapter;

public class MainClass {
    /**
     * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0
     */
    public static void main(String[] args) {
        String version1 = "5.2.3790.24123";
        String version2 = "5.11.7883";

        int compareTo = version1.compareTo(version2);

        System.out.println(compareTo);
    }
}