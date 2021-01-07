package com.lmb.hello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2020-11-11 13:50
 */
public class WhileTest {

    public static void main(String[] args) {

        List<String> list = Collections.unmodifiableList(new ArrayList<>());
        list.clear();
    }

    public static boolean test(){
        while (true) {
            return true;
        }
    }
}