package com.lmb.orm.controller;

import com.lmb.orm.entity.User;
import com.lmb.orm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-15 15:30
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("query")
    public User query(){
        return userService.query(1);

    }
}