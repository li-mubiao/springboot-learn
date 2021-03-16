package com.lmb.hello.builder;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-16 15:16
 */
public class BuilderMain {

    public static void main(String[] args) {
        Director director = new Director();//创建装机人员
        director.setBuilder(new LowConfigBuilder()); //告诉装机人员电脑配置，这里为低配版
        director.createComputer(); //装机人员开始组装
        Computer computer = director.getComputer(); //从装机人员获取组装好的电脑
        System.out.print("1电脑配置：" + computer.toString());  //查看电脑配置

        System.out.println();

        director.setBuilder(new HighConfigBuider());
        director.createComputer();
        computer = director.getComputer();
        System.out.println("2电脑配置：" + computer.toString());
    }
}