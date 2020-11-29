package com.example.demo.java8;

/**
 * @Description:
 * @Author: crx
 * @Create: 17:12 2020/11/29
 */
public interface DefaultMethod {
    default void print(){
        System.out.println("默认方法!");
    }

    void print2();
}
