package com.example.demo.study;

public class NoSynchronizedDemo implements Runnable {

    public static final int MAX = 1000;

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        NoSynchronizedDemo instance = new NoSynchronizedDemo();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX; i++) {
            increase();
        }
    }

    public synchronized static void increase() {
        System.out.println(Thread.currentThread().getName());
        count++;
        synchronized (NoSynchronizedDemo.class) {
            count++;
        }
    }

}