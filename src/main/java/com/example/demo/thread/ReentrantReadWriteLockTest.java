package com.example.demo.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description:
 * @Author: crx
 * @Create: 15:22 2020/5/15
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        MyReadWriteLock myReadWriteLock = new MyReadWriteLock();
        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(() -> {
                myReadWriteLock.put(temp + "", temp + "");
            }, temp + "").start();
        }

        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(() -> {
                myReadWriteLock.get(temp + "");
            }, temp + "").start();
        }
    }

    static class MyReadWriteLock {
        private volatile Map<String, String> map = new HashMap<>();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        public void put(String key, String value) {
            readWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完成");
            readWriteLock.writeLock().unlock();
        }

        public void get(String key) {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取完成");
            readWriteLock.readLock().unlock();
        }
    }
}
