package com.example.demo.study;

/**
 * @Author: crx
 * @Create: 11:44 2020/1/2
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton2.getSingleton2();
    }
}
