package com.example.demo.thread;

/**
 * @Description: ThreadLocal测试类
 * @Author: crx
 * @Create: 16:30 2020/7/16
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> local = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) {
        local.set(local.get() + 1);
        System.out.println(local.get());
        local.remove();
        System.out.println(local.get());
    }
}
