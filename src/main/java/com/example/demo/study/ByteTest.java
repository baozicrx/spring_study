package com.example.demo.study;

/**
 * @Author: crx
 * @Create: 14:20 2020/1/2
 */
public class ByteTest {
    public static void main(String[] args) {
        byte a = 127;
        byte b = 127;
        a += b;
        //强制类型提升造成的
        //a = a + b;
        System.out.println(a);
    }
}
