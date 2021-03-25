package com.lmb.hello;

import java.util.TreeMap;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-24 16:26
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<A,String> map = new TreeMap();
        map.put(new A(),"1234");
    }
}
class A implements Comparable{

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}