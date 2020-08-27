package com.example.demo.study;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

/**
 * @Author: crx
 * @Create: 16:36 2020/3/31
 */
public class Atomic {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        LongAdder a = new LongAdder();
        Stream.of("1", "2").forEach(e -> {
            System.out.println(i.addAndGet(2));
            System.out.println(i.getAndAdd(2));
            a.increment();
            System.out.println(a);
        });
    }
}
