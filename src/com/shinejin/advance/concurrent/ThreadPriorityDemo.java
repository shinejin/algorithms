package com.shinejin.advance.concurrent;

public class ThreadPriorityDemo {

    public static void demo() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                    System.out.println("I am t1 run");
            }
        });
        t1.setPriority(Thread.MIN_PRIORITY);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                    System.out.println("I am t2 run");
            }
        });
        t2.setPriority(Thread.NORM_PRIORITY);


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                    System.out.println("I am t3 run");
            }
        });
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

    }
}
