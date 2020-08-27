package com.example.demo.study;

import com.example.demo.beanUtils.Account;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: crx
 * @Create: 13:51 2019/10/31
 */
public class HashMapTest {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) throws Exception {
//        java.util.Map map = new java.util.HashMap(1000, 8);
//        map.put("1", 1);
//        System.out.println(tableSizeFor(1000));
        System.out.println(8 / 0.75f + 1f);

        Map<String, String> map = new HashMap<>();
        map.put("hollis", "hollischuang");
        map.putIfAbsent("hollis", "11111");
        Integer a = 2;
        System.out.println("1111");

        Class<?> mapType = map.getClass();
        Method capacity = mapType.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity : " + capacity.invoke(map));

        Field size = mapType.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size : " + size.get(map));

        Map map1 = new HashMap();
        map1.put(new Account(1, new Date(), BigDecimal.valueOf(1)), 1);
        System.out.println(map1.get(new Account(1, new Date(), BigDecimal.valueOf(1))));
    }

    private static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
