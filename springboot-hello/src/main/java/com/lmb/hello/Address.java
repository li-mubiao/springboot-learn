package com.lmb.hello;

import lombok.Data;

import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Copyright (C), 2020,
 * FileName: Address
 * Author:   mubiao0205@gmail.com
 * Date:     2020/7/25 23:22
 * Description: TODO
 * Version:1.0.0
 */
@Data
public class Address {
    private String address;

    private List<String> json;

    public static void main(String[] args) throws NoSuchMethodException, IntrospectionException {
        Stream.of("one", "two", "three", "four")
                         .filter(e -> e.length() > 3)
                         .peek(e -> System.out.println("Filtered value: " + e))
                         .map(String::toUpperCase)
                         .peek(e -> System.out.println("Mapped value: " + e))
                         .collect(Collectors.toList());

    }
}