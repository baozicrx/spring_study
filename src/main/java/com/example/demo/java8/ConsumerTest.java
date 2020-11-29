package com.example.demo.java8;

import java.util.function.Consumer;

/**
 * @Description:
 * @Author: crx
 * @Create: 18:55 2020/11/29
 */
public class ConsumerTest {
    public static void generateX(Consumer<String> consumer) {
        consumer.accept("hello consumer");
    }
    public static void main(String[] args) {
        generateX(s->System.out.println(s));
    }
}
