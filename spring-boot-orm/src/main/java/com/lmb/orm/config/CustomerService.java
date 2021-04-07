package com.lmb.orm.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Copyright (C), 2021,
 * FileName: CustomerService
 * Author:   mubiao0205@gmail.com
 * Date:     2021/4/5 下午4:07
 * Description: TODO
 * Version:1.0.0
 */
public class CustomerService {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void initIt() throws Exception {
        System.out.println("Init method after properties are set : " + message);
    }

    @PreDestroy
    public void cleanUp() {
        System.out.println("Spring Container is destroy! Customer clean up");
    }


        public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:app.xml");

        CustomerService   customerService  =  (CustomerService)context.getBean("customerService");

        customerService.cleanUp();
    }
}