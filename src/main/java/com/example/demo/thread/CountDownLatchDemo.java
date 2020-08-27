package com.example.demo.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: crx
 * @Create: 10:14 2020/5/12
 */
public class CountDownLatchDemo {
    final static SimpleDateFormat sdf = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    final static String startTime = sdf.format(new Date());

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);// 两个赛跑者
        Stats stats1 = new Stats("任务A", 1000, countDownLatch);
        Stats stats2 = new Stats("任务B", 2000, countDownLatch);
        Stats stats3 = new Stats("任务C", 2000, countDownLatch);
        Stats stats4 = new Stats("任务D", 2000, countDownLatch);
        Stats stats5 = new Stats("任务E", 2000, countDownLatch);
        System.out.println("所有的统计任务开始:" + sdf.format(new Date()));
        stats1.start();//任务A开始执行
        stats2.start();//任务B开始执行
        stats3.start();//任务C开始执行
        stats4.start();//任务D开始执行
        stats5.start();//任务E开始执行
        countDownLatch.await(3, TimeUnit.SECONDS);// 等待所有人任务结束
        System.out.println("所有的统计任务执行完成:" + sdf.format(new Date()));
    }

    static class Stats extends Thread {
        String statsName;
        int runTime;
        CountDownLatch countDownLatch;

        public Stats(String statsName, int runTime, CountDownLatch countDownLatch) {
            this.statsName = statsName;
            this.runTime = runTime;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println(statsName+ " do stats begin at "+ startTime);
                //模拟任务执行时间
                Thread.sleep(runTime);
                System.out.println(statsName + " do stats complete at "+ sdf.format(new Date()));
                countDownLatch.countDown();//单次任务结束，计数器减一
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
