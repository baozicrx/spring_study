package com.example.demo.study;

import com.google.common.collect.HashBasedTable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: crx
 * @Create: 9:38 2019/12/18
 */
public class SynchronizedMap1 {
    public static void main(String[] args) {
        Map<String, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
        synchronizedMap.put("123", "123");
        synchronizedMap.put(null, null);

        Hashtable hashtable = new Hashtable();
        hashtable.put("123", "123");
        /** Hashtable 是不允许键或值为 null 的 */
//        hashtable.put(null, null);

        Map<String, Object> map = new HashMap<>();
        map.put("123", "123");
        /** HashMap 的键值则都可以为 null */
        map.put(null, null);

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("123", "123");
        concurrentHashMap.putIfAbsent("123","111");
        /** ConcurrentHashMap 是不允许键或值为 null 的 */
//        concurrentHashMap.put(null, null);

    }
}
