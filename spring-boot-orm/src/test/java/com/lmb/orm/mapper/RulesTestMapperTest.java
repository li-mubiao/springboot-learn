package com.lmb.orm.mapper;

import com.alibaba.fastjson.JSONObject;
import com.lmb.orm.entity.RulesTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class RulesTestMapperTest {

    @Autowired
    private RulesTestMapper rulesTestMapper;


    @Test
    public void testInsert(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","阿颖");
        RulesTest rulesTest = new RulesTest();
        rulesTest.setDate(LocalDateTime.now());
        rulesTest.setSysName("测试");
        rulesTest.setRules(jsonObject);
        rulesTestMapper.insertTest(rulesTest);
    }

    @Test
    public void testGet(){
        RulesTest test = rulesTestMapper.getTest(1);
        JSONObject rules = test.getRules();
        System.out.println(rules);
    }

}