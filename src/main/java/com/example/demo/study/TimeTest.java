package com.example.demo.study;

import org.joda.time.DateTime;

import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: crx
 * @Create: 11:36 2020/7/3
 */
public class TimeTest {
    public static void main(String[] args) {
        System.out.println(new DateTime().toString("yyyymmdd"));
        System.out.println(LocalDateTime.now());
    }
}
