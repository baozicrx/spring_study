package com.example.demo.thunisoft;

import java.io.IOException;

import com.thunisoft.summer.component.crypto.CryptUtil;

/**
 * @Description:
 * @Author: crx
 * @Create: 11:34 2020/9/1
 */
public class CryptUtilTest {
    public static void main(String[] args) throws IOException {
        String decrypt = CryptUtil.decrypt("DESede", "YZco3jcyxLQ8C8EeC5fpwg==", "DESede");
        String encrypt = CryptUtil.encrypt("DESede", "黄符谷", "DESede");
        System.out.println(decrypt);
        System.out.println(encrypt);
    }
}
