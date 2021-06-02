package com.lmb.orm.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Copyright (C), 2021, 广州致景信息科技有限公司
 * FileName: MyBatisConfig
 * Author:   limubiao@zj.tech
 * Date:     2021/5/26 23:04
 * Description: TODO
 * Version:1.0.0
 */
@Configuration
public class MyBatisConfig {

    /**
     * 注册分页插件
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}