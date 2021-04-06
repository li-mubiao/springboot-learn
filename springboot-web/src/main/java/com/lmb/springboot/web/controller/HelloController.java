package com.lmb.springboot.web.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Copyright (C), 2020,
 * FileName: HelloController
 * Author:   mubiao0205@gmail.com
 * Date:     2020/3/29 12:02
 * Description: TODO
 * Version:1.0.0
 */
@RestController
@Slf4j
public class HelloController {


    @RequestMapping("/hello")
    public String hello(){
//
//        System.out.println(address.getJson().size());
//        System.out.println(address);

        return "hello-world";
    }


    List<String> list = new ArrayList<>();

    @GetMapping("internperformance")
    public int internperformance(@RequestParam(value = "size", defaultValue = "10000000")int size) {
        //-XX:+PrintStringTableStatistics
        //-XX:StringTableSize=10000000
        long begin = System.currentTimeMillis();
        list = IntStream.rangeClosed(1, size)
                .mapToObj(i-> String.valueOf(i).intern())
                .collect(Collectors.toList());
        log.info("size:{} took:{}", size, System.currentTimeMillis() - begin);
        return list.size();
    }

}