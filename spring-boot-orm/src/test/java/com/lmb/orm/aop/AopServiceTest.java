package com.lmb.orm.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopServiceTest {

    @Autowired
    private AopService aopService;

    @Test
    public void testAop(){
        aopService.aopOrder();
    }
}