package com.lmb.orm.service;

import com.lmb.orm.entity.User;
import com.lmb.orm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-15 14:06
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User query(Integer id){
        return userMapper.query(id);
    }
}