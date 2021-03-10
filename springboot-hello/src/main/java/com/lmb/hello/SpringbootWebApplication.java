package com.lmb.hello;

import com.lmb.hello.proxy.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringbootWebApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringbootWebApplication.class, args);
        TestService testService = context.getBean(TestService.class);
        System.out.println("testService = " + testService.getClass());
    }

}
