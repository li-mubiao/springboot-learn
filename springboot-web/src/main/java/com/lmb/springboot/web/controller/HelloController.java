package com.lmb.springboot.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2020,
 * FileName: HelloController
 * Author:   mubiao0205@gmail.com
 * Date:     2020/3/29 12:02
 * Description: TODO
 * Version:1.0.0
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){

        return "hello-world";
    }

}