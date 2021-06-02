package com.lmb.orm.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Copyright (C), 2021, 广州致景信息科技有限公司
 * FileName: MetaObjectHandler
 * Author:   limubiao@zj.tech
 * Date:     2021/5/26 22:28
 * Description: TODO
 * Version:1.0.0
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert开始属性填充");
        this.strictInsertFill(metaObject,"createTime", LocalDateTime.class,LocalDateTime.now());
        this.strictInsertFill(metaObject,"updateTime", LocalDateTime.class,LocalDateTime.now());
//        this.strictInsertFill(metaObject,"is_deleted",Boolean.class,false);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("update开始属性填充");
        this.strictUpdateFill(metaObject,"updateTime", LocalDateTime.class,LocalDateTime.now());
    }
}