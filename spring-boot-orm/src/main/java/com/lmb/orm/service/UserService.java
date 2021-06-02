package com.lmb.orm.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmb.orm.entity.User;
import com.lmb.orm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-15 14:06
 */
@Service
public class UserService extends ServiceImpl<UserMapper,User> {

    public User queryById(Integer id){

        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper
                .eq(User::getId, id);
        return baseMapper.selectOne(userLambdaQueryWrapper);
    }

    public List<User> queryByName(String name){
        return baseMapper.queryByName(name);
    }

}