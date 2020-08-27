package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * @Author: crx
 * @Create: 17:08 2020/3/30
 */
@Getter
@AllArgsConstructor
public enum AgeType {
    AGE_TYPE1("age0_18", 1),
    AGE_TYPE2("age19_30", 2),
    AGE_TYPE3("age31_40", 3),
    AGE_TYPE4("age41_50", 4),
    AGE_TYPE5("age51-60", 5),
    AGE_TYPE6("age61", 6);

    /** 描述 */
    private String description;

    /** 编码 */
    private Integer code;

    public static AgeType of(Integer code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElse(null);
    }
}
