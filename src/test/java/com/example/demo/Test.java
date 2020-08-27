package com.example.demo;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: crx
 * @Create: 9:41 2020/3/25
 */
public class Test {
    public static void main(String[] args) {
//        String a = "main-action-holder";
//        String[] strings = a.split("-");
//        StringBuffer buffer = new StringBuffer();
//        buffer.append(strings[0]);
//        for (int i = 1; i < strings.length; i++) {
//            buffer.append(strings[i].substring(0,1).toUpperCase()+strings[i].substring(1));
//        }
//        System.out.println(buffer);
//        Calculation(1);
        for (int i = 1; i <= 500; i++) {
            if (i % 2 == 0) {
                int total = 0;
                for (int j = 2; j <= i; j++) {
                    if (i % j == 0) {
                        total += i / j;
                    }
                }
                if (total==i){
                    System.out.println(i);
                }
            }
        }
    }

    public static void Calculation(int n) {
        Set<Integer> integerSet = new HashSet<>();
        for (int i = 2 * n; i <= 12 * n; i++) {
            integerSet.add(i);
        }
        Integer avg = new AtomicReference<>((int) integerSet.stream().mapToInt(Integer::intValue).summaryStatistics().getAverage()).get();
        int mod = 0;
        System.out.println(avg);
        for (Integer e : integerSet) {
            if (e <= avg) {
                mod++;
                System.out.println(e + ":" + ((int) Math.pow(mod, n)) + "/" + (int) Math.pow(36, n));
            } else {
                mod--;
                System.out.println(e + ":" + ((int) Math.pow(mod, n)) + "/" + (int) Math.pow(36, n));
            }
        }
    }

}
