package com.lmb.hello.builder;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-16 15:16
 */
public class Director {
    private ComputerConfigBuilder mBuilder;
    public void setBuilder(ComputerConfigBuilder builder){
        this.mBuilder = builder;
    }
    public void createComputer(){
        mBuilder.setCPU();
        mBuilder.setMemery();
        mBuilder.setHardDisk();
        mBuilder.setKeyboard();
        mBuilder.setMouse();
    }
    public Computer getComputer(){
        return mBuilder.getComputer();
    }
}