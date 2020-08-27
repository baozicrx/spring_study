package com.example.demo.study;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import java.util.List;
import java.util.Map;

/**
 * @Title: PerCentCalUtil
 * @Description: 百分比计算工具
 * @Author 郑乾成
 * @Date 2019/10/12 11:19
 */
public class PerCentCalUtil {

    private static int accuracy = 2;

    private static boolean sign = true;

    /**
     * @param input        输入数据
     * @param inFieldName  需要计算百分比的字段名
     * @param outFieldName 求得百分比的字段名
     * @param accuracy     保留小数位数
     * @param sign         是否带百分号
     */
    public static List<Map<String, Object>> addPercent(List<Map<String, Object>> input,
                                                       String inFieldName,
                                                       String outFieldName,
                                                       int accuracy,
                                                       boolean sign) {
        Double sum = 0.0;
        //求和
        for (Map<String, Object> item : input) {
            sum += MapUtils.getDouble(item, inFieldName);
        }
        //计算百分比
        for (Map<String, Object> item : input) {
            String percent = String.format("%." + accuracy + "f", MapUtils.getDouble(item, inFieldName) / sum * 100);
            if (sign) {
                percent = percent + "%";
            }
            item.put(outFieldName, percent);
        }
        return input;
    }

    /**
     * 计算百分比，默认保留两位小数，带百分号
     *
     * @param input        输入数据
     * @param inFieldName  需要计算百分比的字段名
     * @param outFieldName 求得百分比的字段名
     */
    public static List<Map<String, Object>> addPercent(List<Map<String, Object>> input,
                                                       String inFieldName,
                                                       String outFieldName) {
        return addPercent(input, inFieldName, outFieldName, accuracy, sign);
    }

    /**
     * @param input        输入数据
     * @param inFieldName  需要计算百分比的字段名
     * @param outFieldName 求得百分比的字段名
     * @param accuracy     保留小数位数
     * @param sign         是否带百分号
     */
    public static List<Map<String, Object>> percentage(List<Map<String, Object>> input,
                                                       String inFieldName,
                                                       String outFieldName,
                                                       int accuracy,
                                                       boolean sign) {
        String format = "%." + accuracy + "f";
        if (CollectionUtils.isEmpty(input)) {
            return input;
        }
        double sum = input.stream().mapToDouble(e -> MapUtils.getDoubleValue(e, inFieldName)).sum();
        double count = 0;
        for (int i = 0; i < input.size(); i++) {
            double per;
            //定位到最后一个元素
            if (input.size() - 1 == i) {
                per = Double.parseDouble(String.format(format, 100 - count));
            } else {
                per = Double.parseDouble(String.format(format, MapUtils.getDoubleValue(input.get(i), inFieldName) / sum * 100));
                count = count + per;
            }
            if (sign) {
                input.get(i).put(outFieldName, per + "%");
            } else {
                input.get(i).put(outFieldName, per);
            }
        }
        return input;
    }
}
