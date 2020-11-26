package com.example.demo.study;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.lang3.StringUtils;

import com.example.demo.dto.DocumentFile;
import com.example.demo.dto.Yjjd;

/**
 * @Description:
 * @Author: crx
 * @Create: 13:39 2020/10/21
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<DocumentFile> list1 = new ArrayList<>();
        list1.add(new DocumentFile("1", "1"));
        list1.add(new DocumentFile("2", "2"));
        list1.add(new DocumentFile("3", "2"));
        list1.add(new DocumentFile("4", "3"));
        list1.add(new DocumentFile("5", "3"));

//        CopyOnWriteArrayList<DocumentFile> list2 =  new CopyOnWriteArrayList<>();
//        list2.addAll(list1);
//
//        for (int i = list1.size() - 1; i >= 0; i--) {
//            String wsclid = list1.get(i).getWsclid();
//            String path = list1.get(i).getPath();
//            for (int j = list1.size() - 1; j >= 0; j--) {
//                String wsclid1 = list1.get(j).getWsclid();
//                String path1 = list1.get(j).getPath();
//                if (!StringUtils.equals(wsclid, wsclid1) && StringUtils.equals(path, path1)) {
//                    list1.remove(j);
//                }
//            }
//        }
        list1.removeIf(documentFile -> StringUtils.equals("1", "1") && StringUtils.equals(documentFile.getPath(), "2"));
        System.out.println(list1);
    }
}
