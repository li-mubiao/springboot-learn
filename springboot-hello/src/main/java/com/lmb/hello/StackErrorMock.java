package com.lmb.hello;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-02-24 10:07
 */
public class StackErrorMock {

    private static int index = 1;

    public void call(){
        index++;
        call();
    }

    public static void main(String[] args) {
        StackErrorMock mock = new StackErrorMock();
        try {
            mock.call();
        }catch (Throwable e){
            System.out.println("Stack deep : "+index);
            e.printStackTrace();
        }
    }
}