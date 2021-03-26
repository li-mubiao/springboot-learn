package com.lmb.hello.builder;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-16 15:11
 */
public class LowConfigBuilder implements ComputerConfigBuilder{


    private Computer mComputer;

    public LowConfigBuilder(){
        this.mComputer = new Computer();
    }

    @Override
    public void setCPU() {
        this.mComputer.setCPU("i5");
    }

    @Override
    public void setMemery() {
        mComputer.setMemory("8G");

    }

    @Override
    public void setHardDisk() {
        mComputer.setHardDisk("500G");

    }

    @Override
    public void setKeyboard() {
        mComputer.setKeyboard("薄膜键盘");

    }

    @Override
    public void setMouse() {
        mComputer.setMouse("有线鼠标");

    }

    @Override
    public Computer getComputer() {
        return mComputer;
    }
}