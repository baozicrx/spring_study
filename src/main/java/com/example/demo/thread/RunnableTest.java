package com.example.demo.thread;

/**
 * @Description:
 * @Author: crx
 * @Create: 9:47 2020/7/1
 */
public class RunnableTest {
    public static void main(String[] args) {
        new Thread(new RunnableThread()).start();
    }
}

class RunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println("success");
    }
}
