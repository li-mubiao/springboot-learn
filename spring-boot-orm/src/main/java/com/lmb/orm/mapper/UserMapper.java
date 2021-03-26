package com.lmb.orm.mapper;

import com.lmb.orm.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-15 14:06
 */
@Mapper
public interface UserMapper {

    User query(int id);
}
