package com.example.demo.study;

import com.example.demo.annotation.Excel;
import com.example.demo.annotation.Excels;
import com.example.demo.dto.UserOperateModel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 放射相关测试类
 * @Author: crx
 * @Create: 14:15 2020/7/23
 */
public class reflectTest {
    public static void main(String[] args) {
        List<Field> tempFields = new ArrayList<>();
        List<Field> fields1 = Arrays.asList(UserOperateModel.class.getSuperclass().getDeclaredFields());
        List<Field> fields2 = Arrays.asList(UserOperateModel.class.getDeclaredFields());
        System.out.println(fields1);
        System.out.println(fields2);
        tempFields.addAll(fields1);
        tempFields.addAll(fields2);
        for (Field field : tempFields) {
//            boolean present = field.isAnnotationPresent(Excel.class);
//            System.out.println(present);
//            //单注解
//            if (present) {
//                Excel excel = field.getAnnotation(Excel.class);
//                System.out.println(excel);
//            }
            boolean presents = field.isAnnotationPresent(Excels.class);
            System.out.println(presents);
            //多注解
            if (presents) {
                Excels excels = field.getAnnotation(Excels.class);
                System.out.println(excels);
            }
        }
    }
}
