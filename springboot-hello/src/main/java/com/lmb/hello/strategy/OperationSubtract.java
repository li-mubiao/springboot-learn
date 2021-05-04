package com.lmb.hello.strategy;

import org.springframework.stereotype.Service;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-04-07 13:40
 */
@Service
public class OperationSubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}