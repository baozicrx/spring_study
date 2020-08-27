package com.example.demo.study;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: crx
 * @Create: 17:35 2020/1/13
 */
@Data
@AllArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    Integer age;
}
