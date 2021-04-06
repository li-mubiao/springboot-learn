package com.lmb.orm.aop;

import org.springframework.stereotype.Service;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-04-01 11:49
 */
@Service
public class AopService {

    @AopCheck
    public void aopOrder(){
        System.out.println("执行业务逻辑");
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
        }
    }
}