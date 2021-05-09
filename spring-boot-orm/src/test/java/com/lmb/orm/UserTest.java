package com.lmb.orm;

import com.lmb.orm.entity.User;
import com.lmb.orm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;


    @Test
    public void testGet() {
        User query = userService.query(1);
        System.out.println(query);
    }




}