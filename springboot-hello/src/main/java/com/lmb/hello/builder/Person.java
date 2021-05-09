package com.lmb.hello.builder;

import lombok.ToString;

@ToString
public class Person {
    private String name;
    private Integer age;

    Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.age = personBuilder.age;
    }
    public static Person.PersonBuilder builder() {
        return new Person.PersonBuilder();
    }

    public static class PersonBuilder{
        private String name;
        private Integer age;
        PersonBuilder() {
        }
        public Person.PersonBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public Person.PersonBuilder age(final Integer age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        Person test = Person.builder().name("test").age(20).build();
        System.out.println(test);
    }
}
