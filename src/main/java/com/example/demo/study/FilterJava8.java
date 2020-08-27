package com.example.demo.study;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilterJava8 {

    public static void main(String[] args) {

        List<Person> peoples = Arrays.asList(
                new Person("", 22),
                new Person("js", null),
                new Person("css", 31)
        );

//        peoples = null;

        String patten = "java-22,js-35";

        List<String> pattenList = null;
        List<String> pattenListTemp = Optional.ofNullable(pattenList).orElseGet(ArrayList::new);
//        pattenList.add("java-22");
//        pattenList.add("js-35");

        List<Person> result1 = peoples.stream()
                .filter(p -> StringUtils.isNotEmpty(p.getName()) && p.getAge() != null)
                .collect(Collectors.toList());
        System.out.println("result1=" + result1);

        Person result2 = peoples.stream()
                .filter(p -> "spring".equals(p.getName()))
                .findAny()
                .orElse(null);
        System.out.println(result2);

        Person result3 = peoples.stream()
                .filter((p) -> "java".equals(p.getName()) && 22 == p.getAge())
                .findAny()
                .orElse(null);
        System.out.println(result3);

        // 使用map收集
        String name = peoples.stream()
                .filter(p -> "js".equals(p.getName()))
                .map(Person::getName)
                .findAny()
                .orElse("");
        System.out.println(name);
        System.out.println("---------");

        List<String> names = peoples.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        names.forEach(System.out::println);
    }
}