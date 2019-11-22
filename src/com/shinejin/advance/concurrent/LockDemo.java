package com.shinejin.advance.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    static  Lock mLock = new ReentrantLock();

    public static void demo(){

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " get waiting ...");
                mLock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock and running ...");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mLock.unlock();
                    System.out.println(Thread.currentThread().getName() + " unlock ...");
                }
            }
        }, "Thread 1");

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " get waiting ...");

                try {
                    if(mLock.tryLock(5000, TimeUnit.MILLISECONDS)) {
                        System.out.println(Thread.currentThread().getName() + " get lock and running ...");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            mLock.unlock();
                            System.out.println(Thread.currentThread().getName() + " unlock ...");
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " trylock inter ...");
                    e.printStackTrace();
                }
            }
        }, "Thread 2");

        t2.start();

        try {
            Thread.sleep(1000);
            /**
             * mLock.tryLock 可以响应中断，而Synchronized不可以响应中断
             */
            t2.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
