package com.lmb.hello;

import lombok.Data;

/**
 * Copyright (C), 2020,
 * FileName: Person
 * Author:   mubiao0205@gmail.com
 * Date:     2020/7/25 23:22
 * Description: TODO
 * Version:1.0.0
 */
@Data
public class Person implements Cloneable {

    private String name;

    private Integer age;

    private  Address address;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.setName(new String("123456"));
        person.setAge(33);
        Address address = new Address();
        address.setAddress("浙江杭州");
        person.setAddress(address);
        Person newPerson = (Person) person.clone();
        System.out.println(person == newPerson);
        System.out.println(person.getAddress() == newPerson.getAddress());
        person.getAddress().setAddress("我是测试");
        person.setName(new String("789"));
        System.out.println(newPerson);
    }

}
