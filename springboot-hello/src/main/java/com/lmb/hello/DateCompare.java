package com.lmb.hello;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Copyright (C), 2020,
 * FileName: DateC
 * Author:   mubiao0205@gmail.com
 * Date:     2020/5/14 21:30
 * Description: TODO
 * Version:1.0.0
 */
public class DateCompare {

    public static void main(String[] args) {
        Instant instant = LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault())
                .toInstant();
        Date from = Date.from(instant);
        System.out.println(new Date().compareTo(from));
    }

}