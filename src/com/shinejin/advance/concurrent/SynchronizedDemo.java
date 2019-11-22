package com.shinejin.advance.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SynchronizedDemo {

    ////////////////////////////////////////////
    public static class SyncTestObj{
        int cnt = 0;
        public void handle(){

            System.out.println(Thread.currentThread().getName() + " handle begin ...");
            synchronized (this)
            {
                System.out.println(Thread.currentThread().getName() + " running ...");
                for(int i = 0; i <= 10; i ++) {
                    cnt += i;

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            System.out.println(Thread.currentThread().getName() + " handle end ..."+cnt);
        }

        /**
         * 1. synchronized 修饰对象方法，锁的是对象实例
         * 即testSync() 和 即testSync() 不能同时执行
         * testSync() 和 testSync2() 也不能同时执行
         * obj1.testSync() 和 obj2.testSync() 可以同时执行
         *
         * 2. synchronized修饰静态方法，锁式当前类的Class
         * 即 obj1.testStaticSync() 和 obj2.testStaticSync() 不能同时执行
         * obj1.testStaticSync() 和obj1.testSync() 可以同时执行
         *
         * 3. synchronized修饰代码块，锁是Synchronized配置的对象
         * 即 如果testSyncMethod() 锁定的是 synchronized (this) ||  synchronized(SyncTestObj.this), 则锁定的是对象本身，同（1）
         *    如果testSyncMethod() 锁定的是 synchronized (SyncTestObj.class), 锁式当前类的Class，同（2）
         *    *如果 testSyncMethod() 锁定的是synchronized(SyncTestObj.this)， testSyncMethod2() 锁定的是synchronized(SyncTestObj.class)， 则testSyncMethod() 和 testSyncMethod2()可以同时执行
         */

        public synchronized void testSync() {
            System.out.println(Thread.currentThread().getName() + " testSync begin ...");
            {
                System.out.println(Thread.currentThread().getName() + " testSync running ...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + " testSync end ...");
        }

        public synchronized void testSync2() {
            System.out.println(Thread.currentThread().getName() + " testSync2 begin ...");
            {
                System.out.println(Thread.currentThread().getName() + " testSync2 running ...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + " testSync2 end ...");
        }

        public static synchronized void testStaticSync() {
            System.out.println(Thread.currentThread().getName() + " testSync begin ...");
            {
                System.out.println(Thread.currentThread().getName() + " testSync running ...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + " testSync end ...");
        }

        public static synchronized void testStaticSync2() {
            System.out.println(Thread.currentThread().getName() + " testSync2 begin ...");
            {
                System.out.println(Thread.currentThread().getName() + " testSync2 running ...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + " testSync2 end ...");
        }

        public void testSyncMethod(){

            System.out.println(Thread.currentThread().getName() + " testSyncMethod ...");
            synchronized (SyncTestObj.this) {
                System.out.println(Thread.currentThread().getName() + " testSyncMethod begin ...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }



            System.out.println(Thread.currentThread().getName() + " testSyncMethod end ...");
        }

        public void testSyncMethod2(){

            System.out.println(Thread.currentThread().getName() + " testSyncMethod2 ...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " testSyncMethod2 end ...");
        }

        public void testNoneSync() {
            System.out.println(Thread.currentThread().getName() + " testNoneSync begin ...");
            {
                System.out.println(Thread.currentThread().getName() + " testNoneSync running ...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName() + " testNoneSync end ..."+cnt);
        }

    }

    public static void demo1(){
        SyncTestObj obj = new SyncTestObj();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //while (true)
                    obj.testSyncMethod();
            }
        }, " t1 ");
        t1.start();

        Thread  t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //while (true)
                obj.testSyncMethod();
            }
        }, " t2 ");
        t2.start();

        try {
            Thread.sleep(1000);
            t1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    ////////////////////////////////////////////
}
