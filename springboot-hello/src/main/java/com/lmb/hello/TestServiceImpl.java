package com.lmb.hello;

import org.springframework.stereotype.Component;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-09 17:27
 */
@Component
public class TestServiceImpl implements TestService {
    @Override
    public void eatCarrot() {
        System.out.println("吃萝卜");
    }

    @Override
    public void eatMushroom() {
        System.out.println("吃蘑菇");
    }

    @Override
    public void eatCabbage() {
        System.out.println("吃白菜");
    }
}