package com.lmb.hello;

import lombok.Data;

import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;
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
        Class<Address> addressClass = Address.class;
        Object obj = addressClass.getMethod("setAddress",String.class).getDefaultValue();
        System.out.println(obj);
        //内省机制操作
        BeanInfo beanInfo = Introspector.getBeanInfo(Address.class,Object.class);
        System.out.println(beanInfo);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        System.out.println(propertyDescriptors);
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println(propertyDescriptor.getWriteMethod());
        }
        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
        Stream.of(methodDescriptors).forEach(System.out::println);
        System.out.println("--===============");
        EventSetDescriptor[] eventSetDescriptors = beanInfo.getEventSetDescriptors();

        Stream.of(eventSetDescriptors).forEach(System.out::println);

    }
}