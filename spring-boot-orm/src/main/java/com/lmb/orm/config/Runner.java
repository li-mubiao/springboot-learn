package com.lmb.orm.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2021, 广州致景信息科技有限公司
 * FileName: CommandLineRunner
 * Author:   limubiao@zj.tech
 * Date:     2021/6/4 10:56
 * Description: TODO
 * Version:1.0.0
 */
@Component
public class Runner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("The Runner start to initialize ...");

    }
}