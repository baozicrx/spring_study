package com.example.demo.study;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @Author: crx
 * @Create: 17:10 2019/10/29
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            UUID uuid = UUID.randomUUID();
            System.out.println(uuid);
        } catch (Exception e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
            LOGGER.info("{}", e.getMessage());
        }
        System.out.println(isOdd(1));
//        System.gc();

        List<String> list = new ArrayList();
        for (String l : list) {
            System.out.println(l);
        }


        String a = "2020-04-25 09";
        System.out.println(a.replace("-", "").replace(" ", ""));

        String[] b = {"1", "2"};
        String bb = "202004270011";
        System.out.println(Arrays.asList(b).contains(bb));
        System.out.println(Lists.newArrayList(b).contains(b));
        Integer aa = Integer.valueOf(bb.substring(10, 12));
        System.out.println(aa);
        //通过Runtime方法来获取当前服务器cpu内核，根据cpu内核来创建核心线程数和最大线程数
        System.out.println("线程数=" + Runtime.getRuntime().availableProcessors());

    }

    private static boolean isOdd(int i) {
        return (i & 1) == 0;
    }

}
