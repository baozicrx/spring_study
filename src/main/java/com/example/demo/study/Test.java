package com.example.demo.study;

import org.springframework.util.DigestUtils;

/**
 * @Author: crx
 * @Create: 10:06 2020/1/8
 */
public class Test {
    public static void main(String[] args) {
        int a = 10;
        System.out.println(10 >> 1);

        double aa = 2.0D;
        double bb = 3.0D;
        System.out.println(aa / bb);
        String sysId = "";
        String userId = "";
        String key = "";
        Long times = System.currentTimeMillis();
        String number = "13222783992";
        String token = DigestUtils.md5DigestAsHex((sysId + userId + key + times).getBytes()).toLowerCase();
        String md5Number = DigestUtils.md5DigestAsHex(number.getBytes()).toLowerCase();
        System.out.println("time=" + times);
        System.out.println("token=" + token);
        System.out.println("md5Number=" + md5Number);
    }
}
