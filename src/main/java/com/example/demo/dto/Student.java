package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: crx
 * @Create: 16:38 2020/11/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;

    private String age;

    public static void staticSt(Student student){
        System.out.println("st");
    }

    public void st() {
        System.out.println("st");
    }

    public void st(Student student) {
        System.out.println("st");
    }
}
