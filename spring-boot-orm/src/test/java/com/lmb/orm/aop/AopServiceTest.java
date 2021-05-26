package com.lmb.orm.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AopServiceTest {

    @Autowired
    private AopService aopService;

    @Test
    public void testAop(){
        aopService.aopOrder();
    }
}