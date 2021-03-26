package com.lmb.orm.entity;

import lombok.Data;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-15 14:06
 */
@Data
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String realName;

}