package com.example.demo.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import com.example.demo.dto.TAjlc;

/**
 * @Description:
 * @Author: crx
 * @Create: 11:41 2020/11/3
 */
public class AnyMatchTest {
    public static void main(String[] args) {
        TAjlc tAjlc1 = new TAjlc("1", "a");
        TAjlc tAjlc2 = new TAjlc("1", "b");
        TAjlc tAjlc3 = new TAjlc("1", "c");
        TAjlc tAjlc4 = new TAjlc("1", "d");
        List<TAjlc> list = new ArrayList() {{
            add(tAjlc1);
            add(tAjlc2);
            add(tAjlc3);
            add(tAjlc4);
        }};

        List<TAjlc> list2 = new ArrayList();
        list2.add(null);
        boolean a2 = list2.stream().filter(Objects::nonNull).map(TAjlc::getCAjjdjp).anyMatch(e -> StringUtils.equals("a", e));
        System.out.println("a2=" + a2);

        List<String> collect = list.stream().filter(Objects::nonNull).map(TAjlc::getCAjjdjp).collect(Collectors.toList());
        System.out.println(collect);
        boolean a = list.stream().filter(Objects::nonNull).map(TAjlc::getCAjjdjp).anyMatch(e -> StringUtils.equals("a", e));
        System.out.println(a);

    }
}
