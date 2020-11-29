package com.example.demo.java8;

import java.util.function.Function;

/**
 * @Description:
 * @Author: crx
 * @Create: 18:19 2020/11/29
 */
public class FunctionTest {
    // 将数字转换为String类型
    private static void numberToString(Function<Number, String> function) {
        String apply = function.apply(12);
        System.out.println("转换结果:" + apply);

        //返回一个执行了apply()方法之后只会返回输入参数的函数对象
//        Object apply2 = Function.identity().apply(2);
//        System.out.println("identity结果:" + apply2);

    }

//    private static void method_andThen(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
//        Integer apply = f1.andThen(f2).apply(2);
//        System.out.println(apply);
//    }
//
//    private static void method_compose(Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
//        Integer apply = f1.compose(f2).apply(2);
//        System.out.println(apply);
//    }

    public static void main(String[] args) {
        numberToString(s -> String.valueOf(s));
//        method_andThen(s -> s + 1, s -> s = s * 2);
//        method_compose(s -> s + 1, s -> s = s * s);
    }
}
