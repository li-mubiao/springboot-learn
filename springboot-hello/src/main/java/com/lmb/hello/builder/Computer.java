package com.lmb.hello.builder;

import lombok.Data;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-16 15:05
 */
@Data
public class Computer {
    /*CPU*/
    private String CPU;
    /*内存*/
    private String memory;
    /*硬盘*/
    private String hardDisk;
    /*键盘*/
    private String keyboard;
    /*鼠标*/
    private String mouse;
}