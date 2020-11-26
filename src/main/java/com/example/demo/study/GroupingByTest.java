package com.example.demo.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.checkerframework.checker.units.qual.A;

import com.example.demo.dto.DocumentFile;
import com.example.demo.dto.DocumentNavigation;
import com.google.api.client.util.ArrayMap;
import com.google.common.collect.Lists;

/**
 * @Description:
 * @Author: crx
 * @Create: 17:08 2020/10/20
 */
public class GroupingByTest {
    public static void main(String[] args) {
        List<DocumentFile> list = new ArrayList<>();
        List<DocumentFile> list2 = new ArrayList<>();
        List<DocumentNavigation> list3 = new ArrayList<>();
        list.add(new DocumentFile("1", "1"));
        list.add(new DocumentFile("2", "1"));
        list.add(new DocumentFile("3", "2"));
        list.add(new DocumentFile("4", "2"));
        list.add(new DocumentFile("5", null));
        list.add(new DocumentFile("6", null));
        list3.add(new DocumentNavigation("11", "11", list));

        Map<String, List<DocumentFile>> map = list.stream().collect(Collectors.groupingBy(documentFile -> Optional.ofNullable(documentFile.getPath()).orElseGet(String::new)));
        System.out.println("map=" + map);
        //分组的其它实现方式
        Map<String, ArrayList<DocumentFile>> map2 = list.stream().collect(Collectors.toMap(DocumentFile::getPath, Lists::newArrayList, (o1, o2) -> {
            o1.addAll(o2);
            return o1;
        }));
        System.out.println("map2=" + map2);

        handle(list2, list3);
        System.out.println(list2);
        System.out.println(StringUtils.isEmpty(new String()));
    }

    private static void handle(List<DocumentFile> list2, List<DocumentNavigation> list3) {
        list3.get(0).getWsFile()
                .stream()
                .collect(Collectors.groupingBy(documentFile -> Optional.ofNullable(documentFile.getPath()).orElseGet(String::new)))
                .forEach((x, y) -> {
                    if (StringUtils.isEmpty(x)) {
                        list2.addAll(y);
                    } else {
                        list2.add(y.get(0));
                    }
                });
        list3.get(0).setWsFile(list2);
    }
}
