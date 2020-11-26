package com.example.demo.study;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.alibaba.fastjson.JSON;
import com.example.demo.beanUtils.AccountDto;

/**
 * @Author: crx
 * @Create: 15:32 2019/12/26
 */
public class StringMain {

    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        StringUtils.isEmpty(s2);
        StringUtils.isBlank(s2);
        System.out.println(s == s2);
        System.out.println(s.equals(s2));

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

        Integer s5 = 10;
        System.out.println(String.format("%03d", s5));
        System.out.println(StringUtils.leftPad(String.valueOf(s5), 3, "0"));
        String replace = StringUtils.replace("aba", "a", "z");

        String PRIVARYKEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMeUUY3VbUeOmWSG0JWNp7j/67qL/XTKb45jpjM3tg2TNEq+DJJPuQ6h72qasfr+ADSetuHRJFA9CH5uOpRethxf9mgN3fCIRIrzb4KKPJnEoN0jO6a12INVuNFAreNOH7IREC+oRRbWvYs9CslBvVNKR1j0HEGqNcAAQ6NSn7rzAgMBAAECgYB9qTVwSGF2HKMYWIocoARqxzh1TI9ZadyzmqqatQk7ouPZ66+er/Ok8vD7/krx7dvTRduAc16Z5tPiRyU7JiciuL5osMEsSGRXqSKoEtptGffPFfSUONNnswcA3IaBP5sRurVx9fuNmBpAo6dMGlVQ/HYClGZAcsTR9vyzo5QOgQJBAPdKN3lgoB5J3tEHc0ng4n7muqWW4ctD/hgcPx51ZZGvjr+MUB4vGAjenF+vuKdTHZqCQGeE/gFuz1HO5A8EOlUCQQDOm+bVJeGtE8kiin8WQU/peyVItqw3Q2tLBSuSo+hn/OKQGxJj+/dWNbv0oiONZw/0nX7sn3kbMeqnBQKQF3gnAkA7ujQ938WsqyDjEc6ZuHRcPDQ2jIPKyYhUoHXqUGaQ0ntC7ovnTm6ardHNFq8d0uhiijUuC6QiCnaOhs70hYvlAkAxoXO22g23JNyZJonWz8Ohg4p2SCNgdxqL/+byp9sJN8847LfjOsC0fd3zqws9SXekvDykHL7b0IbcrjBqaqjbAkEAh9QFMhZ9kFPi+CtL4x4CSzp7B9+ednibn8yug5780M0nRP75/ca1mzl0Bon5EIuhknPZfwXEHdGr2DvM1imJdQ==";
        System.out.println(PRIVARYKEY);

        String PUBLICKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHlFGN1W1HjplkhtCVjae4/+u6i/10ym+OY6Yz\n" +
                "N7YNkzRKvgyST7kOoe9qmrH6/gA0nrbh0SRQPQh+bjqUXrYcX/ZoDd3wiESK82+CijyZxKDdIzum\n" +
                "tdiDVbjRQK3jTh+yERAvqEUW1r2LPQrJQb1TSkdY9BxBqjXAAEOjUp+68wIDAQAB";

        StringBuilder builder = new StringBuilder();
        StringBuffer buffer = new StringBuffer();
        buffer.append("123456");
        System.out.println("buffer=" + buffer.substring(0, buffer.length() - 1));

        String fileName = "123.txt";
        String extension = FilenameUtils.getExtension(fileName);
        System.out.println("文件名称=" + extension);
        int i = fileName.lastIndexOf(".");
        String s1 = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(s1);
        System.out.println(i);

        String[] format = {"txt", "doc"};
        System.out.println(Arrays.asList(format).contains(s1));

        System.out.println("addTest=" + addTest(1));

        //string转数组
        String dzdm = "[\"1\",\"2\",\"4\",\"3\",\"5\"]";
//        dzdm = "[]";
        dzdm = null;
//        dzdm = "1,2,3,4";
//        dzdm = "[" + dzdm + "]";
        List<String> parseArray = JSON.parseArray(dzdm, String.class);
//        for (String ss:parseArray){
//            System.out.println(ss);
//        }
//        parseArray.forEach(System.out::println);
        System.out.println(CollectionUtils.isEmpty(parseArray));
        System.out.println(parseArray);

        String tag = "{1,2,3}";
        tag = null;
//        System.out.println(tag.replace("{", "[").replace("}","]"));
        System.out.println(StringUtils.containsAny(tag, "{", "}"));

        String aa = null;
        String replace1 = Optional.ofNullable(aa).orElse(StringUtils.EMPTY).replace("{", "[").replace("}", "]");
        System.out.println(replace1);

        String aaa = "111111,";
        aaa = null;
        System.out.println("removeStart=" + StringUtils.removeStart(aaa, ","));
        System.out.println("removeEnd=" + StringUtils.removeEnd(aaa, ","));

        //判断实体类是否为空
        AccountDto accountDto = new AccountDto();
        System.out.println("accountDto=" + org.springframework.util.StringUtils.isEmpty(accountDto));

        //String转list
        String b = "b,c";
        List<String> stringList = Collections.singletonList(b);
        System.out.println("stringList=" + stringList);

        //for循环拼接字符串
        String jj = "1";
        for (int j = 0; j < 10; j++) {
            jj += i;
        }

    }

    public static Integer addTest(Integer i) {
        try {
            return i;
        } finally {
            return i + 1;
        }
    }
}
