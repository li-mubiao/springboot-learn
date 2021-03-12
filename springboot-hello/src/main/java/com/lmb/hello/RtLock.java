package com.lmb.hello;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author 李木标 limubiao@i72.com
 * @since 2021-03-10 14:03
 */
public class RtLock {



    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            //1 第一个线程进来,设置为宿主线程直接返回true
            //2 第二个线程进来，判断进来的线程和当前线程是否相同，
            //如果相同可以获取到锁。否则获取不到锁,返回false.
            int state = getState();
            Thread t = Thread.currentThread();
            if (state == 0) {
                if (compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(t);
                    return true;
                }
            } else if (t == getExclusiveOwnerThread()) {
                setState(state + 1);//记录同一个线程进来的次数
                return true;
            }
            return false;
        }

        //锁的释放和加锁肯定是一一对应的,加锁了几次，就释放锁几次。
        // 直到记录的状态值更新为0
        @Override
        protected boolean tryRelease(int arg) {
            //释放锁时候,如果释放的线程不是当前的线程直接抛出异常
            if (Thread.currentThread() != getExclusiveOwnerThread()) {
                throw new RuntimeException();
            }
            int state = getState() - arg;
            setState(state);
            if (state == 0) {
                setExclusiveOwnerThread(null);
                return true;
            }
            return false;
        }
    }

    private Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unLock() {
        sync.release(1);
    }
}