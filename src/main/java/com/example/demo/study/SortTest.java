package com.example.demo.study;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.example.demo.dto.Yjjd;

/**
 * @Description:
 * @Author: crx
 * @Create: 10:13 2020/10/21
 */
public class SortTest {
    public static void main(String[] args) {
        List<Yjjd> list1 = new ArrayList<>();
        list1.add(new Yjjd("1", LocalDateTime.now().plusMinutes(5)));
        list1.add(new Yjjd("1", LocalDateTime.now().plusMinutes(10)));
        list1.add(new Yjjd("1", null));
        System.out.println(list1);
        //正序
        list1.sort(Comparator.comparing(yjjd -> Optional.ofNullable(yjjd.getFssj()).orElseGet(LocalDateTime::now)));
        System.out.println(list1);
        //倒序
        list1.sort((m1, m2) -> m2.getFssj().compareTo(m1.getFssj()));
        System.out.println(list1.size());

        //保留第一条数据
//        List<Yjjd> list = list1.subList(0, 1);
//        System.out.println(list);

        List<Yjjd> collect = list1.stream().limit(1).collect(Collectors.toList());
        System.out.println(collect);
    }
}
