package com.lmb.hello;

/**
 * Copyright (C), 2020,
 * FileName: JavaVMStackSOF
 * Author:   mubiao0205@gmail.com
 * Date:     2020/4/5 11:45
 * Description: 演示栈溢出
 * VM args: -Xss128k
 * Version:1.0.0
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }


    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:"+oom.stackLength);
            throw e;
        }
    }


}