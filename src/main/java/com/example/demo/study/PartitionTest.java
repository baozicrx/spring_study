package com.example.demo.study;


import org.joda.time.DateTime;

/**
 * @Author: crx
 * @Create: 10:05 2020/1/7
 */
public class PartitionTest {
    public static void main(String[] args) {
        DateTime dateTime = new DateTime().plusDays(-2);
        System.out.println(dateTime);
        for (int i = 0; i < 720; i++) {
            String part = dateTime.plusHours(i).toString("yyyyMMddHH");
            String descr = dateTime.plusHours(i+1).toString("yyyyMMddHH")+"00";
            System.out.println("partition pd"+part+" values less than ('"+descr+"'),");
        }
    }
}
