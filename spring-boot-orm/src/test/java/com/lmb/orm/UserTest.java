package com.lmb.orm;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmb.orm.entity.User;
import com.lmb.orm.mapper.UserMapper;
import com.lmb.orm.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserTest {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void queryList(){
        List<User> list = userService.list();
        System.out.println(list);
    }



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

    @Test
    public void queryByName(){
        List<User> users = userService.queryByName("Billie");
        users.forEach(System.out::println);
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setDeleted(false);
        user.setName("阿颖");
        user.setAge(20);
        user.setEmail("123@163.com");
        userService.save(user);
    }
    @Test
    public void testUpdae(){
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id",7);
        userUpdateWrapper.set("age",21);
        userService.update(userUpdateWrapper);
    }

    @Test
    public void testRemove(){
        userService.removeById(1);
    }

    @Test
    public void testPage(){
        Page<User> page = new Page<>(2,2);
        userService.page(page, new QueryWrapper<User>().between("age",20,25)
                                                        .likeLeft("name","颖"));
        List<User> employeeList = page.getRecords();
        employeeList.forEach(System.out::println);
        System.out.println("获取总条数:" + page.getTotal());
        System.out.println("获取当前页码:" + page.getCurrent());
        System.out.println("获取总页码:" + page.getPages());
        System.out.println("获取每页显示的数据条数:" + page.getSize());
        System.out.println("是否有上一页:" + page.hasPrevious());
        System.out.println("是否有下一页:" + page.hasNext());
    }

}