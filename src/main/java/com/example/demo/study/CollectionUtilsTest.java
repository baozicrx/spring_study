package com.example.demo.study;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

/**
 * @Description: CollectionUtils工具类笔记
 * @Author: crx
 * @Create: 13:45 2020/8/19
 */
public class CollectionUtilsTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list1 = new ArrayList();
        list1.add(1);
        list1.add(5);
        List list2 = new ArrayList();
        List list3 = null;
        List<String> list4 = new ArrayList();
        list4.add("1");
        list4.add("4");
        List<Integer> list5 = new ArrayList();
        list5.add(1);
        list5.add(2);
        list5.add(2);
        List<Integer> list6 = new ArrayList();
        list6.add(1);
        list6.add(2);
        list6.add(3);
        System.out.println("初始化空的Collection集合");
        System.out.println("(1):" + CollectionUtils.EMPTY_COLLECTION);
        System.out.println("如果参数为null，或参数本身，则返回一个不可变的空集合");
        System.out.println("(1):" + CollectionUtils.emptyIfNull(list1));
        System.out.println("(2):" + CollectionUtils.emptyIfNull(list2));
        System.out.println("(3):" + CollectionUtils.emptyIfNull(list3));
        System.out.println("返回两个集合的并集");
        System.out.println("(1):" + CollectionUtils.union(list, list1));
        System.out.println("(2):" + CollectionUtils.union(list, list4));
        System.out.println("返回两个集合的交集");
        System.out.println("(1):" + CollectionUtils.intersection(list, list1));
        System.out.println("(2):" + CollectionUtils.intersection(list, list4));
        System.out.println("返回两个集合的异或（对称差）");
        System.out.println("(1):" + CollectionUtils.disjunction(list, list1));
        System.out.println("(2):" + CollectionUtils.disjunction(list, list4));
        System.out.println("返回两个集合的差集");
        System.out.println("(1):" + CollectionUtils.subtract(list, list1));
        System.out.println("(2):" + CollectionUtils.subtract(list, list4));
        System.out.println("A集合是否全部包含B集合");
        System.out.println("(1):" + CollectionUtils.containsAll(list, list1));
        System.out.println("(2):" + CollectionUtils.containsAll(list, list5));
        System.out.println("返回一个Map，将给定Collection中的每个唯一元素映射到一个Integer，代表该元素在Collection中出现的次数");
        System.out.println("(1):" + CollectionUtils.getCardinalityMap(list5));
        System.out.println("如果a是b的子集合，则返回true");
        System.out.println("(1):" + CollectionUtils.isSubCollection(list, list1));
        System.out.println("(2):" + CollectionUtils.isSubCollection(list, list4));
        System.out.println("返回两个集合是否具有完全相同的元素");
        System.out.println("(1):" + CollectionUtils.isEqualCollection(list, list1));
        System.out.println("(2):" + CollectionUtils.isEqualCollection(list, list6));
        System.out.println("从输入集合中选择所有与给定谓词匹配的元素到输出集合中");
        System.out.println("(1):" + CollectionUtils.select(list, e -> e > 1));
        System.out.println("使用给定的转换器转换输入迭代器中的所有元素，并将其添加到输出集合中");
        System.out.println("(1):" + CollectionUtils.collect(list, e -> e * 2));
        System.out.println("将迭代中的所有元素添加到给定的集合中");
        System.out.println("(1):" + CollectionUtils.addAll(list, list1));
        System.out.println(list);
        System.out.println("根据条件过滤集合内元素，不满足条件删除对应元素");
        System.out.println("(1):" + CollectionUtils.filter(list, e -> e < 5));
        System.out.println(list);
        System.out.println("获取指定集合/迭代器的大小");
        System.out.println("(1):" + CollectionUtils.size(list));
        System.out.println("空安全检查指定的集合是否为空");
        System.out.println("(1):" + CollectionUtils.isEmpty(list));
        System.out.println("(2):" + CollectionUtils.isEmpty(list3));
        System.out.println("获取集合可以包含的最大元素数");
        System.out.println("(1):" + CollectionUtils.maxSize(list));
        System.out.println("将两个已排序的集合a和b合并到一个已排序的列表中，以便保留元素的自然顺序");
        System.out.println("(1):" + CollectionUtils.collate(list, list1));
        System.out.println("返回输入集合的所有排列");
        System.out.println("(1):" + CollectionUtils.permutations(list));
        System.out.println("从collection中删除remove中的元素");
        System.out.println("(1):" + CollectionUtils.removeAll(list, list1));
    }
}
