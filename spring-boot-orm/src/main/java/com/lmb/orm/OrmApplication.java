package com.lmb.orm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-15 11:41
 */
@SpringBootApplication
@ComponentScan("com.lmb")
@MapperScan("com.lmb.orm.mapper")
@EnableTransactionManagement
public class OrmApplication {


    public static void main(String[] args) {
        SpringApplication.run(OrmApplication.class, args);
    }

}