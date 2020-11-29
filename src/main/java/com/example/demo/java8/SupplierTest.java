package com.example.demo.java8;

import java.util.function.Supplier;

/**
 * @Description:
 * @Author: crx
 * @Create: 18:59 2020/11/29
 */
public class SupplierTest {
    private static String test_Supplier(Supplier<String> suply) {
        return suply.get(); //供应者接口
    }
    public static void main(String[] args) {
        // 产生的数据作为 sout 作为输出
        System.out.println(test_Supplier(()->"产生数据"));
    }
}
