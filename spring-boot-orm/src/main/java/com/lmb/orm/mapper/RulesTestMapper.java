package com.lmb.orm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lmb.orm.entity.RulesTest;
import com.lmb.orm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Copyright (C), 2021, 广州致景信息科技有限公司
 * FileName: RulesTestMapper
 * Author:   limubiao@zj.tech
 * Date:     2021/6/2 11:39
 * Description: TODO
 * Version:1.0.0
 */
@Mapper
public interface RulesTestMapper extends BaseMapper<RulesTest> {



    Boolean insertTest(RulesTest rulesTest);


    RulesTest getTest(@Param("id") Integer id);

}