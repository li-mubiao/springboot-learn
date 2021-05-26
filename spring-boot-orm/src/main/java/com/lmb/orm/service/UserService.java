package com.lmb.orm.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lmb.orm.entity.User;
import com.lmb.orm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-15 14:06
 */
@Service
public class UserService {


    private final UserMapper userMapper;


    @Autowired
    public UserService(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    @Transactional
    public User query(Integer id){

        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper
                .eq(User::getId, id);
        return userMapper.selectOne(userLambdaQueryWrapper);
    }
}