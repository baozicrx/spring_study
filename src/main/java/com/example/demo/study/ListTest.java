package com.example.demo.study;


import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * @Author: crx
 * @Create: 13:59 2019/10/24
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> strings = Collections.synchronizedList(list);
        list.add("crx");
        list.add("crj");
//        list.removeIf("crj"::equals);
        for (String s : list) {
            if ("crx".equals(s)) {
                list.remove(s);
            }
        }
        List<String> list1 = new ArrayList<String>() {{
            add("123");
            add("456");
        }};

        List list2 = new ArrayList(10);
        list.addAll(new ArrayList<>());
        System.out.println(list1);
        System.out.println(list2.size());


//        list.forEach(e -> {
//            if ("crj".equals(e)){
//                list.remove(e);
//            }
//        });

        List<Map<String, Object>> mapList1 = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name" + i, i);
            mapList1.add(map);
        }
        List<Map<String, Object>> mapList2 = ListUtils.deepCopy(mapList1);
        mapList1.forEach(e -> {
            e.put("age", 11);
        });
        System.out.println("mapList1=" + mapList1);
        System.out.println("mapList2=" + mapList2);

        String[] arrays = {"1", "2", "3"};
        List<String> list3 = Arrays.asList(arrays);
        List<String> list4 = Lists.newArrayList(arrays);
        //java.util.Arrays$ArrayList

        //list3.add("4");
        list4.add("4");
//        String[] whiteIps = {"1","2"};
        String whiteIps = "*";
//        String whiteIps = "http://10.33.178.135:8001,http://www.jszhdc.cn,http://221.226.175.82:9930,http://112.4.2.177:50018,http://localhost:8080";
        List<String> asList = Arrays.asList(whiteIps);
        System.out.println(asList.get(0));

        List<? extends Number> foo = new ArrayList<>();
        List<? super Integer> foo1 = new ArrayList<Integer>();
        List<? super Integer> foo2 = new ArrayList<Number>();
        List<? super Integer> foo3 = new ArrayList<Object>();
        foo2.add(1);
//        Object object = foo1.get(0);
//        Object object1 = foo2.get(0);
//        Object object2 = foo3.get(0);

        List<Object> objectList = new ArrayList<>();
        CollectionUtils.containsAny(objectList, "A", "B");
    }
}
