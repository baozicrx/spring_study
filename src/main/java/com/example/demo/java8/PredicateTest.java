package com.example.demo.java8;

import java.util.function.Predicate;

/**
 * @Description:
 * @Author: crx
 * @Create: 18:47 2020/11/29
 */
public class PredicateTest {

    // 判断字符串是否存在o  即使生产者 又是消费者接口
    private static void method_test(Predicate<String> predicate) {
        boolean b = predicate.test("OOM SOF");
        System.out.println(b);
    }

    // 判断字符串是否同时存在o h 同时
    private static void method_and(Predicate<String> predicate1, Predicate<String> predicate2) {
        boolean b = predicate1.and(predicate2).test("OOM SOF");
        System.out.println(b);
    }

    //判断字符串是否一方存在o h
    private static void method_or(Predicate<String> predicate1, Predicate<String> predicate2) {
        boolean b = predicate1.or(predicate2).test("OOM SOF");
        System.out.println(b);
    }

    // 判断字符串不存在o 为真   相反结果
    private static void method_negate(Predicate<String> predicate) {
        boolean b = predicate.negate().test("OOM SOF");
        System.out.println(b);
    }

    public static void main(String[] args) {
        method_test((s) -> s.contains("O"));
//        method_and(s -> s.contains("O"), s -> s.contains("h"));
//        method_or(s -> s.contains("O"), s -> s.contains("h"));
//        method_negate(s -> s.contains("O"));
    }

}
