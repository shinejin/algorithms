package com.shinejin.advance.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadInterrupt {

    /**
     *中断线程两种方式：
     * 1）通过调用 interrupt
     * 2）通过stop flag的方式
     */
    //
    //
    public static void demo() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                    try {
                        for(int i = 0; i < 1000; i ++) {

                            if(Thread.interrupted()) {
                                throw new InterruptedException();
                            }

                            System.out.println("I am running ...i:" + i);
                        }


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        });

        t1.start();

        try {
            Thread.sleep(1);

            //调用interrupt只是设置线程的中断标志位，并不会让线程停止
            //需要在线程中主动判断 Thread.interrupted(), 然后抛异常来终止线程
            t1.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
