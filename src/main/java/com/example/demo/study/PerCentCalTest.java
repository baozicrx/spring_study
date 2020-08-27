package com.example.demo.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: crx
 * @Create: 16:52 2020/4/20
 */
public class PerCentCalTest {
    public static void main(String[] args) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("num", 131376);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("num", 9253);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("num", 1645);
        Map<String, Object> map4 = new HashMap<>();
        map4.put("num", 795);
        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);
        mapList.add(map4);
        mapList = PerCentCalUtil.percentage(mapList, "num", "per", 2, false);
        System.out.println(mapList);
    }
}
