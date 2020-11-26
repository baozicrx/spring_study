package com.example.demo.study;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Description:
 * @Author: crx
 * @Create: 17:23 2020/9/10
 */
public class JSONTTest {
    public static void main(String[] args) {
        String test = "{\"DSxrq\":\"2020-09-18\"}";
        String test2 = String.valueOf(JSON.parseObject(test).get("test2"));
        Object test21 = JSON.parseObject(test).get("test2");
        //测试空指针
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = jsonObject.getJSONObject("111").getJSONArray("111");
        System.out.println("jsonArray=" + jsonArray);
        System.out.println(test2);
        System.out.println(StringUtils.isNotBlank(test2));
        System.out.println(null == test21);
    }
}
