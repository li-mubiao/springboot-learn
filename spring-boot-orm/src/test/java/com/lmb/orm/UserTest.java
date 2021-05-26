package com.lmb.orm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lmb.orm.entity.User;
import com.lmb.orm.mapper.UserMapper;
import com.lmb.orm.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.MockitoAnnotations.openMocks;

@SpringBootTest
public class UserTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void testGet() {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        userLambdaQueryWrapper
                .eq(User::getId, 2);
        User user = userMapper.selectOne(userLambdaQueryWrapper);
        System.out.println(user);
    }

    @Test
    public void queryAll(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }



}