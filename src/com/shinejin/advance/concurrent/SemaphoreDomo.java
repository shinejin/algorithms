package com.shinejin.advance.concurrent;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class SemaphoreDomo {

    /**
     *Semaphore可以用来构建一些对象池，资源池之类的，比如数据库连接池，我们也可以创建计数为1的Semaphore，将其作为一种类似互斥锁的机制
     */




    public static class SemaphoreThread extends Thread {

    }

    public static void demo(){
        Semaphore semaphore = new Semaphore(2);

        ArrayList<Thread> arrThread = new ArrayList<>();
        for(int i = 1; i <= 3; i ++) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {

                    if(semaphore.availablePermits() <= 0) {
                        System.out.println(Thread.currentThread().getName() + " waiting ...");

                    }

                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + " doing ...");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                        System.out.println(Thread.currentThread().getName() + " exit ...");
                    }

                }
            }, "Thread"+i);

            arrThread.add(t1);
        }

        for(Thread t: arrThread) {
            t.start();
        }

    }

}
