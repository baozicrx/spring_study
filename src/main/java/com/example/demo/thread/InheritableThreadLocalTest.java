package com.example.demo.thread;

/**
 * @Description:
 * @Author: crx
 * @Create: 10:10 2020/7/27
 */
public class InheritableThreadLocalTest {
    final static ThreadLocal threadLocal = new InheritableThreadLocal();

    public static void main(String[] args) {
        threadLocal.set("帅得一匹");
        System.out.println(Thread.currentThread().getName());
        Thread t = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println(Thread.currentThread().getName());
                System.out.println(threadLocal.get());
            }
        };
        t.start();
    }
}
