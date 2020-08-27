package com.example.demo.study;

/**
 * @Author: crx
 * @Create: 11:43 2020/1/2
 */
public class Singleton2 {
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getSingleton2() {
        return singleton2;
    }
}
