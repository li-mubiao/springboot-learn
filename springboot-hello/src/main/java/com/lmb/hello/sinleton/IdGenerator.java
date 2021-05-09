package com.lmb.hello.sinleton;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


/**
 * 饿汉式
 */
public class IdGenerator {
    private AtomicInteger id = new AtomicInteger(0);

    private static final IdGenerator instance = new IdGenerator();

    private static final IdGenerator getInstance(){
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}

/**
 * 懒汉式
 */
class IdGenerator1{
    private AtomicInteger id = new AtomicInteger(0);
    private static IdGenerator1 instance;
    private IdGenerator1(){}
    public static synchronized IdGenerator1 getInstance(){
        if(instance==null){
            instance = new IdGenerator1();
        }
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}

/**
 * 双重检测
 */
class IdGenerator2{
    private AtomicInteger id = new AtomicInteger(0);
    private static IdGenerator2 instance;
    private IdGenerator2(){}
    public static IdGenerator2 getInstance(){
        if (instance==null){
            synchronized (IdGenerator2.class){
                if (instance==null){
                    instance = new IdGenerator2();
                }
            }
        }
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}

/**
 * 静态内部类
 */
class IdGenerator3{
    private AtomicInteger id = new AtomicInteger(0);
    private IdGenerator3() {}

    private static class SingletonHolder{
        private static final IdGenerator3 instance = new IdGenerator3();
    }
    public static IdGenerator3 getInstance(){
        return SingletonHolder.instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
}

/**
 * 枚举
 */
enum IdGenerator4{
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);
    public long getId() { return id.incrementAndGet(); }

}


