package com.example.demo.study;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Description:
 * @Author: crx
 * @Create: 16:41 2020/4/23
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println(LocalDateTime.now().getMonthValue());

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        System.out.println(localDateTime.isAfter(localDateTime2));

        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(date);
    }
}
