package com.shinejin.advance.concurrent;

public class DaemonThread {

    //当所有的非守护线程结束时，程序也就终止了，同时会杀死进程中的所有守护线程

    public static void demo(boolean isDaemon) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("I am running ...");

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.setDaemon(isDaemon);

        t1.start();

    }
}
