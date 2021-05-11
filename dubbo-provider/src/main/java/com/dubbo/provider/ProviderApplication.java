package com.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-15 11:41
 */
@SpringBootApplication
public class ProviderApplication {


    public static void main(String[] args) {
        ThreadLocal<HashMap> hashMapThreadLocal = ThreadLocal.withInitial(() -> new HashMap());
        SpringApplication.run(ProviderApplication.class, args);
    }

}