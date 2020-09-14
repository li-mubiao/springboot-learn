package com.lmb.hello;

import java.util.function.Function;

/**
 * 函数测试
 *
 * @author 李木标 limubiao@i72.com
 * @since 2020-09-14 11:17
 */
public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        System.out.println(test.compute(1,a -> a+1));

        // 普通定义
        Function<Integer,Integer> function = new Function<Integer,Integer>() {
            @Override
            public Integer apply(Integer o) {
                return o * o;
            }
        };
        Function<Integer, String> function1 = function.andThen(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "result is " + integer;
            }
        });

        String apply = function1.apply(3);
        System.out.println(apply);
        // 用lambda的方式实现
        Function<Integer,Integer> lambdaFunc = o -> o*o;
        Function<Integer, String> function2 = lambdaFunc.andThen(o -> "result is " + o);
        String apply1 = function2.apply(3);
        System.out.println(apply1);

    }
    public int compute(int a, Function<Integer,Integer> function){
        return function.apply(a);
    }
}