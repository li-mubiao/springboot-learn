package com.lmb.hello;

/**
 * Copyright (C), 2020,
 * FileName: StringIntern
 * Author:   mubiao0205@gmail.com
 * Date:     2020/4/5 12:01
 * Description: TODO
 * Version:1.0.0
 */
public class StringIntern {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern()=="计算机软件".intern());//true

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern()==str2);//false,注意,"java"在sun.misc.Version已经被加载了


        String str3 ="123";
        String str4 ="12";
        str4 = str4+"3";
        System.out.println(str3==str4.intern());

    }
}