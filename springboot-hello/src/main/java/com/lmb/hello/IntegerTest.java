package com.lmb.hello;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2020-10-15 17:09
 */
public class IntegerTest {
    static int i =0;
    public void aMethod(){

        i++;
        System.out.println(i);
    }
    public static void main(String[] args) {
//        IntegerTest test = new IntegerTest();
//        test.aMethod();
//        test.aMethod();
//        try{
//            int i =1/0;
//            System.out.println("111");
//        }catch (Exception e){
//            System.out.println("222");
//        }
        BigDecimal num = BigDecimal.ZERO;
        num = num.add(new BigDecimal("1")).setScale(2, RoundingMode.HALF_UP);
        System.out.println(num);
    }
}