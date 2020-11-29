package com.example.demo.java8;

import com.example.demo.dto.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Description: 方法引用
 * @Author: crx
 * @Create: 16:28 2020/11/29
 */
public class MethodReference {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        //构造器引用
        Optional.empty().orElseGet(Student::new);
        //静态方法引用
        list.forEach(Student::staticSt);
        //特定类的任意对象的方法引用
        list.forEach(Student::st);
        //特定对象的方法引用
        Student student = new Student();
        list.forEach(student::st);
    }
}
