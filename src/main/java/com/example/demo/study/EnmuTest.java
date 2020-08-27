package com.example.demo.study;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author: crx
 * @Create: 9:50 2019/12/17
 */
@Getter
@AllArgsConstructor
public enum EnmuTest {
    MANJIAN("满减券", "001"),
    ZHEKOU("折扣券", "002"),
    LIJIAN("立减券", "003");

    /**
     * 优惠券描述(分类)
     */
    private String description;

    /**
     * 优惠券分类编码
     */
    private String code;

    public static void main(String[] args) {
        String code = "003";
        try {
            Integer i = null;
            i++;
//            Objects.requireNonNull(null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        EnmuTest enmuTest = Stream.of(values()).filter(e -> e.code.equals(code))
                .findAny().get();
        System.out.println(enmuTest);
        System.out.println(EnmuTest.LIJIAN.getCode());
        for (EnmuTest e : values()) {
            System.out.println(e.ordinal());
        }
    }

    public static EnmuTest of(String code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " not exists!"));
    }
}
