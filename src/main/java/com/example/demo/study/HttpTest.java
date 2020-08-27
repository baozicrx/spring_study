package com.example.demo.study;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: crx
 * @Create: 16:59 2020/5/19
 */
public class HttpTest {
    public static void main(String[] args) {
//        String url = "http://www.jszhdc.cn/traffic_smartCityManagement/sys/getToken";
//        Map<String, Object> map = new HashMap<>();
//        map.put("userName", "");
//        map.put("password", "");
//        map.put("captcha", "");
//        Map<String, String> headerMap = new HashMap<>();
//        headerMap.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
//        headerMap.put("Accept-Encoding","gzip, deflate");
//        headerMap.put("Accept-Language","zh-CN,zh;q=0.9");
//        headerMap.put("Cache-Control","max-age=0");
//        headerMap.put("Connection","keep-alive");
//        headerMap.put("Host","www.jszhdc.cn");
//        headerMap.put("Upgrade-Insecure-Requests","1");
//        headerMap.put("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/81.0.4044.92 Safari/537.36");
//        String body = HttpUtil.createGet(url).headerMap(headerMap,true).execute().body();
//        System.out.println(body);

//        String url = "http://api.jszhdc.cn:50018";
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("app_id", "121000000115");
//        jsonObject.put("process_code", "districtOdReal");
//        jsonObject.put("token", "bee478828c08b1997951b2da52b4e5f5");
//        jsonObject.put("timestamp", "1546051784197");
//        jsonObject.put("time", "202005281000");
//        jsonObject.put("districtId", "320102");
//        jsonObject.put("areaType", "1");
//        System.out.println(jsonObject);
//        String body1 = HttpUtil.createPost(url).body(jsonObject.toJSONString()).execute().charset("UTF-8").body();
//        System.out.println(body1);

//        String url = "http://api.jszhdc.cn:50018";
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("app_id", "sendDmpMsg");
//        jsonObject.put("process_code", "districtOdReal");
//        jsonObject.put("msisdns", "['MpumcWh5QUXhnl9YEV95ZBD8iCTUJNuEnH5nxrB8iD8I4jF6n3VtU23NQJJsFYZSVPD27lREbOnMbLe5pLEmURSA4hXuYXDyoOEr3O3Dj70x78ZfakxYOUNfW+StyeYLqnrYN/Q4v31aKugfC47pgCfkyt6hoEDtW1d3i9S5bFI=']");
//        jsonObject.put("msisdnType", 1);
//        jsonObject.put("smsContent", "['UFxwheMZofGBautUmyAqXAwxQLOQkQphDkcDSsGeJI+gRV/TtkZ0e4TSqKvGgYvE0knEI7yaopG6YzvpRGaTD4gjocTJao6gmd77whiUZ5hyRMOA8t60usI+eXgy89fEX8mzMAVG9MlHM5fx67p+tuM2SP6BxiL9ow8fYB/tj2s=','xFy1s5QJIOTuIFYhXtMjeGJaC7ALSRX/k9kAv3A9NjewCa7K7ty/lzjYDbHQmiAaZpH/Pa9ppafClwwz+WimvVYplEm/KupogumxOs7R9b0jgGK96TE3tsyVS/DVk6HPZGO04zALijEjIbtiP0m8DCR/LFkERq5umM8VswBEX8s=']");
//        jsonObject.put("channelId", "302");
//        System.out.println(jsonObject);
//        String body1 = HttpUtil.createPost(url).body(jsonObject.toJSONString()).execute().charset("UTF-8").body();
//        System.out.println(body1);

        String url = "http://www.jszhdc.cn/traffic_jbProject3/sys/getToken";
        System.out.println(HttpUtil.createGet(url).execute().charset());
        List<HttpCookie> cookies = HttpUtil.createGet(url).execute().getCookies();
        System.out.println(cookies);
        HttpCookie[] httpCookies = cookies.toArray(new HttpCookie[cookies.size()]);
        String body = HttpUtil.createGet(url).cookie(httpCookies).execute().body();
        System.out.println(body);

        String jbUrl = "http://www.jszhdc.cn/traffic_jbProject2/commuteController/queryTrafficLineFlowData";
        String body1 = HttpUtil.createGet(jbUrl).execute().body();
        System.out.println(body1);
    }
}
