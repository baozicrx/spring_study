package com.example.demo.study;

import java.util.Arrays;
import java.util.Optional;

/**
 * @Description:
 * @Author: crx
 * @Create: 9:24 2020/4/23
 */
public class OptionalTest {
    public static void main(String[] args) {
        String a = "null";
        Optional<String> o1 = Optional.empty();
        Optional<String> o2 = Optional.of(a);
        Optional<String> o3 = Optional.ofNullable(null);
        System.out.println(o3.isPresent());
        o3.ifPresent(s -> System.out.println(Arrays.toString(s.split(","))));
        System.out.println(o1.orElse("1"));
        System.out.println(o1.orElseGet(() -> "默认值"));
        Optional<Integer> integerOptional = o2.map(String::length);
        System.out.println(integerOptional.get());
        String password = o2.map(String::toUpperCase).get();
        System.out.println(password);
    }
}
