package com.lmb.orm.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Copyright (C), 2021, 广州致景信息科技有限公司
 * FileName: RulesTest
 * Author:   limubiao@zj.tech
 * Date:     2021/6/2 11:29
 * Description: TODO
 * Version:1.0.0
 */
@TableName("rules_test")
@Data
public class RulesTest {

    /**
     * CREATE TABLE rules_test(
     * id INT PRIMARY KEY AUTO_INCREMENT,
     * sys_name VARCHAR(16) NOT NULL unique,
     * rules JSON,
     * date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
     * );
     */

    private Integer id;

    private String sysName;

    private JSONObject rules;

    private LocalDateTime date;


}