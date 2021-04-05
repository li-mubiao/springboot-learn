package com.lmb.hello.juc;

import java.util.concurrent.locks.StampedLock;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-04-02 17:16
 */
public class Point {

    private final StampedLock stampedLock = new StampedLock();

    private double x;
    private double y;

    /**
     *
     * @param deltaX
     * @param deltaY
     */
    public void move(double deltaX, double deltaY) {
        long stamp = stampedLock.writeLock(); // 获取写锁
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp); // 释放写锁
        }
    }


    /**
     *
     * @return
     */
    public double distanceFromOrigin() throws InterruptedException {
        long stamp = stampedLock.tryOptimisticRead(); // 获得一个乐观读锁
        // 注意下面两行代码不是原子操作
        // 假设x,y = (100,200)
        double currentX = x;
        // 此处已读取到x=100，但x,y可能被写线程修改为(300,400)
        double currentY = y;
        Thread.sleep(3000L);
        // 此处已读取到y，如果没有写入，读取是正确的(100,200)
        // 如果有写入，读取是错误的(100,400)
        if (!stampedLock.validate(stamp)) { // 检查乐观读锁后是否有其他写锁发生
            stamp = stampedLock.readLock(); // 获取一个悲观读锁
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp); // 释放悲观读锁
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    public static void main(String[] args) throws InterruptedException {
        Point point = new Point();
        new Thread(()->point.move(100,200)).start();
       new Thread(()-> {
           double v = 0;
           try {
               v = point.distanceFromOrigin();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println(v);
       }).start();
        new Thread(()->point.move(100,400)).start();
    }
}