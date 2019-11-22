package com.shinejin.advance.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NotifyAndWaitDemo {

    ////////Synchronized下的等待、通知机制实现////////////////////////////

    static boolean flag = true;
    static Object lockObj = new Object();

    public static void demo(){
        new Thread(new WaitRunnable(), "WaitThread 1").start();
        new Thread(new WaitRunnable(), "WaitThread 2").start();
        try {
            TimeUnit.SECONDS.sleep(1);//这里睡眠，是保证Wait线程先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new NotifyRunnable(), "NotifyThread").start();

    }


    static class WaitRunnable implements Runnable{

        @Override
        public void run() {

            synchronized (lockObj) {
                while(flag) {
                    String name = Thread.currentThread().getName();
                    try {
                        System.out.println(name + " wait at "+ new SimpleDateFormat("HH:mm:ss").format(new Date()));

                        //线程调用wait()方法前，需要获得对象的监视器。当调用wait()方法后，会释放对象的监视器
                        // wait() 会释放对象监视器 wait() 会释放对象监视器 wait() 会释放对象监视器
                        lockObj.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(name + " wakeup at "+ new SimpleDateFormat("HH:mm:ss").format(new Date()));
                }
            }
        }
    }

    static class NotifyRunnable implements Runnable {

        @Override
        public void run() {

            synchronized (lockObj) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " notify at " + new SimpleDateFormat("HH:mm:ss").format(new Date()));

                lockObj.notifyAll();

                //这里如果sleep2s，也就是没有释放锁，所以即使notify了，wakeup也不会执行
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                flag = false;
            }


        }
    }
}
