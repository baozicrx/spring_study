package com.example.demo.study;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: crx
 * @Create: 10:29 2019/12/31
 */
public class ParamTest {
    public static void main(String[] args) {
        Integer i = new Integer(1);
        System.out.println("pass1方法调用前，i的值为=" + i);
        pass1(i);
        System.out.println("pass1方法调用后，i的值为=" + i);

        Map<String, String> map = new HashMap() {{
            put("1", "1");
        }};
        System.out.println("pass2方法调用前，i的值为=" + map);
        pass2(map);
        System.out.println("pass2方法调用后，i的值为=" + map);
    }

    public static void pass1(Integer i) {
        i *= 3;
        System.out.println("pass1方法中，i的值为=" + i);
    }

    public static void pass2(Map<String, String> map) {
        map.put("2", "2");
        System.out.println("pass2方法中，map的值为=" + map);
    }
}
