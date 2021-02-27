package com.lmb.hello;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-02-24 10:25
 */
public class StringOomMock {
    static String  base = "string";
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }
}