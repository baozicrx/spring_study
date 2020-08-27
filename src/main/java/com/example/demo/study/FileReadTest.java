package com.example.demo.study;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.CharsetUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Author: crx
 * @Create: 9:04 2020/4/28
 */
public class FileReadTest {
    public static void main(String[] args) {
        String firstPath = System.getProperty("user.dir")+"\\游戏日志";
        File[] ls = FileUtil.ls(firstPath);
        Arrays.stream(ls).forEach(directory -> {
            File[] files = FileUtil.ls(String.valueOf(directory));
            Set<String> user = new HashSet<>();
            Arrays.stream(files).forEach(file -> {
                FileReader fileReader = new FileReader(file, CharsetUtil.CHARSET_GBK);
                fileReader.readLines().forEach(e -> {
                    user.add(e.split("\t")[7]);
                });
            });
            System.out.println(directory.toString().split("\\\\")[4]+"="+user.size());
        });
    }
}
