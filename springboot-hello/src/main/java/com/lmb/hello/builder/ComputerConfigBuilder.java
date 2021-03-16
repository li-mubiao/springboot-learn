package com.lmb.hello.builder;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-16 15:10
 */
public interface ComputerConfigBuilder {

    void setCPU();
    void setMemery();
    void setHardDisk();
    void setKeyboard();
    void setMouse();
    Computer getComputer();
}
