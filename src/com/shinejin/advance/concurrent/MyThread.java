package com.shinejin.advance.concurrent;

public class MyThread {

    public static void demo(){

        ThreadA ta = new ThreadA();
        ta.start();


        Thread tb = new Thread(new RunnableB());
        tb.start();

    }
    //继承Thread
    static class ThreadA extends Thread {
        @Override
        public void run() {

            System.out.println("ThreadA is run");
        }
    }

    //实现runnable接口
    //避免Thread类的单继承的局限性
    static class RunnableB implements Runnable{

        @Override
        public void run() {
            System.out.println("ThreadB is run");
        }
    }



}
