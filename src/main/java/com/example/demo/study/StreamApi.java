package com.example.demo.study;

import org.apache.commons.collections.MapUtils;
import org.joda.time.DateTime;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: crx
 * @Create: 17:38 2020/1/3
 */
public class StreamApi {
    public static void main(String[] args) throws InterruptedException {
        DecimalFormat df = new DecimalFormat("#.00");

        List<Map<String, Integer>> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            Map<String, Integer> map = new HashMap<>();
            map.put("num", i);
            if (i > 2) {
                map.put("num", 0);
            }
            list.add(map);
        }

        IntSummaryStatistics num = list.stream().collect(Collectors.summarizingInt(e -> e.get("num")));
        Integer num1 = list.stream().mapToInt(e -> e.get("num")).sum();
        System.out.println("总计=" + num1);
        System.out.println(num.getCount());
        System.out.println("总计=" + num.getSum());
        System.out.println(df.format(num.getAverage()));
        System.out.println(num.getMax());
        System.out.println(num.getMin());

        int aa = 2;
        int bb = 3;
        double cc = Double.parseDouble(df.format((double) bb / aa));
        System.out.println(cc);

        List<Point> pointList = new ArrayList<>();
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        Point p3 = new Point(3, 3);
        pointList.add(p1);
        pointList.add(p2);
        pointList.add(p3);

        Double[] strings = pointList.stream().map(Point::getX).toArray(Double[]::new);
        System.out.println(strings[0]);

        //排序
        List<Map<String, Object>> timeList = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("time", new DateTime().plusDays(-i).toString("yyyyMMdd"));
            timeList.add(map);
        }
//        timeList.sort(Comparator.comparing(o->MapUtils.getString(o,"time")));
        System.out.println(timeList);

        //分组
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> result = ints.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println(result.get(true));
        System.out.println(result.get(false));

        //ifPresent
        System.out.println("ifPresent");
        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);

        //通过 Supplier 来包装一下流，通过 get() 方法来构建一个新的 Stream 流
        Supplier<Stream<String>> streamSupplier = () -> Stream.of("a1", "a2", "a3").sorted(String::compareTo);
        streamSupplier.get().forEach(System.out::println);
        streamSupplier.get().noneMatch(s -> true);

        List<String> removeCi = null;
//        removeCi.add("111");
        List<String> addCi = null;
//        addCi.add("11");
        addCi = Optional.ofNullable(addCi).orElseGet(ArrayList::new);
        List<String> finalRemoveCi = Optional.ofNullable(removeCi).orElseGet(ArrayList::new);
        addCi = addCi.stream().filter(e -> !finalRemoveCi.contains(e)).collect(Collectors.toList());
        System.out.println(addCi);
    }
}
