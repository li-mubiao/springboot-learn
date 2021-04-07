package com.lmb.hello.strategy;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-04-07 13:41
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}