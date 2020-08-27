package com.example.demo.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: crx
 * @Create: 15:10 2020/5/15
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
    }

    static class MyThread implements Runnable {

        private int ticket = 10;
        // 定义lock锁
        ReentrantLock lock = new ReentrantLock();

        @SneakyThrows
        @Override
        public void run() {
            while (true) {
//                lock.tryLock();
//                lock.tryLock(3, TimeUnit.SECONDS);
//                lock.lockInterruptibly();
                lock.lock();
                try {
                    if (ticket > 0) {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + ":" + ticket--);
                    } else {
                        System.out.println("break");
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
//                    if (lock.isHeldByCurrentThread()){
                        lock.unlock();
//                    }
                }
            }

        }
    }

}
