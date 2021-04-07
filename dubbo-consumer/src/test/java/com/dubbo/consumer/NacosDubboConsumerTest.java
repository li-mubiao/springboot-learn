package com.dubbo.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NacosDubboConsumerTest {

    @Autowired
    private NacosDubboConsumer nacosDubboConsumer;

    @Test
    public void testSay(){

        nacosDubboConsumer.say("hello nacos");
    }

}