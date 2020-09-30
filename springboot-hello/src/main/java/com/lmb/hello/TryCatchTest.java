package com.lmb.hello;

import java.math.BigDecimal;

/**
 * 异常吞并测试
 *
 * @author 李木标 limubiao@i72.com
 * @since 2020-09-30 10:12
 */
public class TryCatchTest {

    public static void main(String[] args) {
        boolean b = tryEx() == false;
        System.out.println(b);
    }
    static boolean tryEx(){
        try {
            BigDecimal bigDecimal = new BigDecimal("");
        }catch (Exception e){
            throw e;
        }
        return true;
    }
}