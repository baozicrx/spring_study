package com.example.demo.study;

/**
 * @Description: Volatile测试类
 * @Author: crx
 * @Create: 9:42 2020/5/11
 */
public class VolatileTest {
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
        System.out.println("11111111111111");
//        for (; ; ) {
            synchronized (threadTest) {
                if (threadTest.isFlag()) {
                    System.out.println("读取成功");
                }
            }
//        }
    }

    static class ThreadTest extends Thread {
        private volatile boolean flag = false;

        public boolean isFlag() {
            return flag;
        }

        @Override
        public void run() {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            flag = true;
            System.out.println("flag=" + flag);
        }
    }
}
