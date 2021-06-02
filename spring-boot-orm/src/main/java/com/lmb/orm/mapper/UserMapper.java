package com.lmb.orm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lmb.orm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-15 14:06
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {


    List<User> queryByName(@Param("name") String name);
}
