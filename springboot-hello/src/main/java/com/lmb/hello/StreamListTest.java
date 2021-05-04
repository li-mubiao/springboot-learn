package com.lmb.hello;

import java.math.BigDecimal;

/**
 * 流测试
 *
 * @author 李木标 limubiao@i72.com
 * @since 2020-10-28 16:45
 */
public class StreamListTest {

    public static void main(String[] args) {
//        List<String> list = Lists.newArrayList("1","2","3");
//        Stream<String> stringStream = list.stream().filter(e -> !"1".equals(e));
//        stringStream.forEach(System.out::println);
        BigDecimal divide = new BigDecimal("10").divide(new BigDecimal("3"), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide);
    }
}