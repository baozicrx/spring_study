package com.example.demo.java8;

import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: crx
 * @Create: 17:20 2020/11/29
 */
@Service
public class DefaultMethodImpl implements DefaultMethod{
    @Override
    public void print2() {
        System.out.println("普通方法");
    }
}
