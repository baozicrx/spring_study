package com.example.demo.study;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.dto.AgeType;
import com.example.demo.dto.ResultDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: crx
 * @Create: 10:21 2020/4/26
 */
public class JsonTest {
    public static void main(String[] args) {
        JSONArray jsonArray = new JSONArray();
        ResultDto resultDto = new ResultDto();
        resultDto.setStatus(0);
        Map<String, Integer> age = new HashMap() {{
            put("a", "a");
        }};
        Map<String, Integer> sex = new HashMap() {{
            put("b", "b");
        }};
        Map<String, Object> data = new HashMap<>();
//        data.put("age", age);
//        data.put("sex", sex);
        resultDto.setData(data);
        String jsonString = JSON.toJSONString(resultDto);
        System.out.println(jsonString);

        //String test = "{\"status\":200,\"msg\":\"操作成功\",\"data\":[{\"fAgeLevel\":6,\"fCityId\":\"1000250\",\"fLineId\":\"100025012000029\",\"fInPer\":\"2.68%\",\"fOutPer\":\"4.24%\",\"fTime\":\"2020042509\",\"fOutCount\":10,\"lineName\":\"S9号线\",\"stationName\":\"高淳站\",\"fStationId\":\"100025011000150\",\"fInCount\":7},{\"fAgeLevel\":-1,\"fCityId\":\"1000250\",\"fLineId\":\"100025012000029\",\"fInPer\":\"29.89%\",\"fOutPer\":\"29.66%\",\"fTime\":\"2020042509\",\"fOutCount\":70,\"lineName\":\"S9号线\",\"stationName\":\"高淳站\",\"fStationId\":\"100025011000150\",\"fInCount\":78},{\"fAgeLevel\":4,\"fCityId\":\"1000250\",\"fLineId\":\"100025012000029\",\"fInPer\":\"14.56%\",\"fOutPer\":\"19.07%\",\"fTime\":\"2020042509\",\"fOutCount\":45,\"lineName\":\"S9号线\",\"stationName\":\"高淳站\",\"fStationId\":\"100025011000150\",\"fInCount\":38},{\"fAgeLevel\":5,\"fCityId\":\"1000250\",\"fLineId\":\"100025012000029\",\"fInPer\":\"16.09%\",\"fOutPer\":\"20.76%\",\"fTime\":\"2020042509\",\"fOutCount\":49,\"lineName\":\"S9号线\",\"stationName\":\"高淳站\",\"fStationId\":\"100025011000150\",\"fInCount\":42},{\"fAgeLevel\":1,\"fCityId\":\"1000250\",\"fLineId\":\"100025012000029\",\"fInPer\":\"0.38%\",\"fOutPer\":\"0.00%\",\"fTime\":\"2020042509\",\"fOutCount\":0,\"lineName\":\"S9号线\",\"stationName\":\"高淳站\",\"fStationId\":\"100025011000150\",\"fInCount\":1},{\"fAgeLevel\":3,\"fCityId\":\"1000250\",\"fLineId\":\"100025012000029\",\"fInPer\":\"11.88%\",\"fOutPer\":\"14.41%\",\"fTime\":\"2020042509\",\"fOutCount\":34,\"lineName\":\"S9号线\",\"stationName\":\"高淳站\",\"fStationId\":\"100025011000150\",\"fInCount\":31},{\"fAgeLevel\":2,\"fCityId\":\"1000250\",\"fLineId\":\"100025012000029\",\"fInPer\":\"24.52%\",\"fOutPer\":\"11.86%\",\"fTime\":\"2020042509\",\"fOutCount\":28,\"lineName\":\"S9号线\",\"stationName\":\"高淳站\",\"fStationId\":\"100025011000150\",\"fInCount\":64}]}";
        String test = "{\"data\":[],\"status\":0}";
        String data1 = JSON.parseObject(test).get("data").toString();
        System.out.println(data1);
        List<Map<String, Object>> jsonArray1 = JSONArray.parseObject(data1, List.class);
        jsonArray1.forEach(e -> {
            age.put(e.get("fAgeLevel").toString(), (Integer) e.get("fInCount"));
            System.out.println("人数=" + e.get("fInCount"));
            System.out.println("年龄=" + e.get("fAgeLevel"));
        });
        System.out.println(jsonArray1);
        System.out.println(JSON.toJSON(age));

        System.out.println(AgeType.of(-1) == null);

        System.out.println("2020041614".substring(0, 8));
        String result = "{\"status\":0,\"data\":{\"table\":[{\"name\":\"中国药科大学站\",\"time\":\"2018-05-04 14:30:01\",\"flow\":994},{\"name\":\"中国药科大学站\",\"time\":\"2018-05-04 14:45:01\",\"flow\":994},{\"name\":\"中国药科大学站\",\"time\":\"2018-05-04 15:00:02\",\"flow\":980},{\"name\":\"中国药科大学站\",\"time\":\"2018-05-04 15:15:01\",\"flow\":939},{\"name\":\"中国药科大学站\",\"time\":\"2018-05-04 15:30:01\",\"flow\":937},{\"name\":\"中国药科大学站\",\"time\":\"2018-05-04 15:45:02\",\"flow\":938},{\"name\":\"中国药科大学站\",\"time\":\"2018-05-04 16:00:01\",\"flow\":997},{\"name\":\"中国药科大学站\",\"time\":\"2018-05-04 16:15:02\",\"flow\":930},{\"name\":\"中国药科大学站\",\"time\":\"2018-05-04 16:30:02\",\"flow\":969},{\"name\":\"中国药科大学站\",\"time\":\"2018-05-04 16:45:01\",\"flow\":937},{\"name\":\"中国药科大学站\",\"time\":\"2018-05-04 17:00:01\",\"flow\":937},{\"name\":\"中国药科大学站\",\"time\":\"2018-05-04 17:15:01\",\"flow\":740}],\"stationFlow\":[{\"name\":\"安德门站\",\"value\":688},{\"name\":\"小行站\",\"value\":919},{\"name\":\"中胜站\",\"value\":147},{\"name\":\"奥体中心站\",\"value\":77},{\"name\":\"梦都大街站\",\"value\":103},{\"name\":\"绿博园站\",\"value\":126},{\"name\":\"江心洲站\",\"value\":196},{\"name\":\"临江站\",\"value\":147},{\"name\":\"浦口万汇城站\",\"value\":87},{\"name\":\"南京工业大学站\",\"value\":64},{\"name\":\"龙华路站\",\"value\":144},{\"name\":\"文德路站\",\"value\":64},{\"name\":\"雨山路站\",\"value\":46},{\"name\":\"迈皋桥站\",\"value\":2320},{\"name\":\"红山动物园站\",\"value\":324},{\"name\":\"南京站\",\"value\":1032},{\"name\":\"新模范马路站\",\"value\":313},{\"name\":\"玄武门站\",\"value\":307},{\"name\":\"鼓楼站\",\"value\":747},{\"name\":\"珠江路站\",\"value\":620},{\"name\":\"新街口站\",\"value\":2853},{\"name\":\"张府园站\",\"value\":546},{\"name\":\"三山街站\",\"value\":335},{\"name\":\"中华门站\",\"value\":2897},{\"name\":\"天隆寺站\",\"value\":508},{\"name\":\"软件大道站\",\"value\":344},{\"name\":\"花神庙站\",\"value\":176},{\"name\":\"南京南站\",\"value\":2047},{\"name\":\"双龙大道站\",\"value\":296},{\"name\":\"河定桥站\",\"value\":526},{\"name\":\"胜太路站\",\"value\":222},{\"name\":\"百家湖站\",\"value\":334},{\"name\":\"小龙湾站\",\"value\":675},{\"name\":\"竹山路站\",\"value\":1083},{\"name\":\"天印大道站\",\"value\":2270},{\"name\":\"龙眠大道站\",\"value\":1172},{\"name\":\"江宁经贸学院站\",\"value\":1410},{\"name\":\"南京交院站\",\"value\":1180},{\"name\":\"中国药科大学站\",\"value\":740},{\"name\":\"油坊桥站\",\"value\":801},{\"name\":\"雨润大街站\",\"value\":135},{\"name\":\"元通站\",\"value\":408},{\"name\":\"奥体东站\",\"value\":280},{\"name\":\"兴隆大街站\",\"value\":224},{\"name\":\"集庆门大街站\",\"value\":409},{\"name\":\"云锦路站\",\"value\":403},{\"name\":\"莫愁湖站\",\"value\":276},{\"name\":\"汉中门站\",\"value\":478},{\"name\":\"上海路站\",\"value\":444},{\"name\":\"大行宫站\",\"value\":1497},{\"name\":\"西安门站\",\"value\":319},{\"name\":\"明故宫站\",\"value\":349},{\"name\":\"苜蓿园站\",\"value\":290},{\"name\":\"下马坊站\",\"value\":375},{\"name\":\"孝陵卫站\",\"value\":224},{\"name\":\"钟灵街站\",\"value\":335},{\"name\":\"马群站\",\"value\":1234},{\"name\":\"金马路站\",\"value\":883},{\"name\":\"仙鹤门站\",\"value\":860},{\"name\":\"学则路站\",\"value\":835},{\"name\":\"仙林中心站\",\"value\":631},{\"name\":\"羊山公园站\",\"value\":569},{\"name\":\"南大仙林校区站\",\"value\":507},{\"name\":\"经天路站\",\"value\":214},{\"name\":\"秣周东路站\",\"value\":68},{\"name\":\"东大九龙湖校区站\",\"value\":102},{\"name\":\"诚信大道站\",\"value\":80},{\"name\":\"九龙湖站\",\"value\":108},{\"name\":\"天元西路站\",\"value\":114},{\"name\":\"胜太西路站\",\"value\":127},{\"name\":\"宏运大道站\",\"value\":203},{\"name\":\"明发广场站\",\"value\":266},{\"name\":\"大明路站\",\"value\":203},{\"name\":\"卡子门站\",\"value\":219},{\"name\":\"雨花门站\",\"value\":235},{\"name\":\"武定门站\",\"value\":405},{\"name\":\"夫子庙站\",\"value\":558},{\"name\":\"常府街站\",\"value\":238},{\"name\":\"浮桥站\",\"value\":517},{\"name\":\"鸡鸣寺站\",\"value\":631},{\"name\":\"新庄站\",\"value\":605},{\"name\":\"小市站\",\"value\":380},{\"name\":\"五塘广场站\",\"value\":512},{\"name\":\"上元门站\",\"value\":376},{\"name\":\"柳洲东路站\",\"value\":659},{\"name\":\"天润城站\",\"value\":321},{\"name\":\"泰冯路站\",\"value\":373},{\"name\":\"东大成贤学院站\",\"value\":121},{\"name\":\"星火路站\",\"value\":82},{\"name\":\"林场站\",\"value\":453},{\"name\":\"翠屏山站\",\"value\":224},{\"name\":\"佛城西路站\",\"value\":126},{\"name\":\"吉印大道站\",\"value\":144},{\"name\":\"正方中路站\",\"value\":1048},{\"name\":\"翔宇路北站\",\"value\":1392},{\"name\":\"翔宇路南站\",\"value\":1273},{\"name\":\"禄口机场站\",\"value\":669},{\"name\":\"泰山新村站\",\"value\":344},{\"name\":\"高新开发区站\",\"value\":873},{\"name\":\"信息工程大学站\",\"value\":1301},{\"name\":\"卸甲甸站\",\"value\":1926},{\"name\":\"大厂站\",\"value\":1242},{\"name\":\"葛塘站\",\"value\":1609},{\"name\":\"长芦站\",\"value\":1146},{\"name\":\"化工园站\",\"value\":921},{\"name\":\"六合开发区站\",\"value\":1853},{\"name\":\"龙池站\",\"value\":129},{\"name\":\"雄州站\",\"value\":98},{\"name\":\"凤凰山公园站\",\"value\":65},{\"name\":\"方州广场站\",\"value\":69},{\"name\":\"沈桥站\",\"value\":656},{\"name\":\"八百桥站\",\"value\":1231},{\"name\":\"金牛湖站\",\"value\":802},{\"name\":\"龙江站\",\"value\":176},{\"name\":\"草场门站\",\"value\":155},{\"name\":\"云南路站\",\"value\":161},{\"name\":\"九华山站\",\"value\":164},{\"name\":\"岗子村站\",\"value\":114},{\"name\":\"蒋王庙站\",\"value\":169},{\"name\":\"王家湾站\",\"value\":103},{\"name\":\"聚宝山站\",\"value\":91},{\"name\":\"徐庄站\",\"value\":112},{\"name\":\"汇通路站\",\"value\":23},{\"name\":\"灵山站\",\"value\":32},{\"name\":\"东流站\",\"value\":26},{\"name\":\"孟北站\",\"value\":30},{\"name\":\"西岗桦墅站\",\"value\":33},{\"name\":\"仙林湖站\",\"value\":224},{\"name\":\"高家冲站\",\"value\":1},{\"name\":\"林山站\",\"value\":295},{\"name\":\"桥林新城站\",\"value\":4},{\"name\":\"石碛河站\",\"value\":34},{\"name\":\"双垅站\",\"value\":56},{\"name\":\"兰花塘站\",\"value\":116},{\"name\":\"马骡圩站\",\"value\":261},{\"name\":\"刘村站\",\"value\":1664},{\"name\":\"天保站\",\"value\":610},{\"name\":\"高庙路站\",\"value\":24},{\"name\":\"吴侯街站\",\"value\":23},{\"name\":\"平良大街站\",\"value\":24},{\"name\":\"永初路站\",\"value\":45},{\"name\":\"贾西站\",\"value\":116},{\"name\":\"春江路站\",\"value\":74},{\"name\":\"铁心桥站\",\"value\":100},{\"name\":\"景明佳园站\",\"value\":85},{\"name\":\"铜山站\",\"value\":277},{\"name\":\"石湫站\",\"value\":1062},{\"name\":\"明觉站\",\"value\":1514},{\"name\":\"团结圩站\",\"value\":396},{\"name\":\"高淳站\",\"value\":879}],\"stationName\":740,\"readZoo\":55,\"temple\":2855,\"southStation\":18091,\"olympicSports\":534,\"station\":4011}}";
        System.out.println(result);

        result = "{\"status\":0,\"data\":{\"time\":[\"00:00\",\"01:00\",\"02:00\",\"03:00\",\"04:00\",\"05:00\",\"06:00\",\"07:00\"],\"num\":[1,2,3,3,21,54,3]}}";
        System.out.println(result);

        result = "{'status':0,'data':{'table':" +
                "[{'line_1':34877,'line_3':20132,'line_s1':20316,'line_s3':6345,'stationName':'南京南站','time':'20180501'}," +
                "{'line_1':34877,'line_3':20132,'line_s1':20316,'line_s3':6345,'stationName':'南京南站','time':'20180502'}," +
                "{'line_1':34877,'line_3':20132,'line_s1':20316,'line_s3':6345,'stationName':'南京南站','time':'20180503'}]," +
                "'total':" +
                "{'line_1':103569,'line_3':68666,'line_s1':51238,'line_s3':18664,'stationFlow':242137," +
                "'source_line_1':101569,'source_line_3':66666,'source_line_s1':51238,'source_line_s3':21664}}}\n";
        System.out.println(result);

        String path = System.getProperty("user.dir");
        System.out.println(path);

        result = "{'status':0,'data':" +
                "[{'date':'20180502','inNum':1,'inPer':'100.0%','outNum':0,'outPer':'0.0%','pathCoding':6130,'pathEnd':2,'pathStart':5,'time':'2018/05/02 05:50','vaild':1}," +
                "{'date':'20180502','inNum':1,'inPer':'100.0%','outNum':0,'outPer':'0.0%','pathCoding':6130,'pathEnd':2,'pathStart':5,'time':'2018/05/02 05:50','vaild':1}," +
                "{'date':'20180502','inNum':1,'inPer':'100.0%','outNum':0,'outPer':'0.0%','pathCoding':6130,'pathEnd':2,'pathStart':5,'time':'2018/05/02 05:50','vaild':1}," +
                "{'date':'20180502','inNum':1,'inPer':'100.0%','outNum':0,'outPer':'0.0%','pathCoding':6130,'pathEnd':2,'pathStart':5,'time':'2018/05/02 05:50','vaild':1}," +
                "{'date':'20180502','inNum':1,'inPer':'100.0%','outNum':0,'outPer':'0.0%','pathCoding':6130,'pathEnd':2,'pathStart':5,'time':'2018/05/02 05:50','vaild':1}," +
                "{'date':'20180502','inNum':1,'inPer':'100.0%','outNum':0,'outPer':'0.0%','pathCoding':6130,'pathEnd':2,'pathStart':5,'time':'2018/05/02 05:50','vaild':1}," +
                "{'date':'20180502','inNum':1,'inPer':'100.0%','outNum':0,'outPer':'0.0%','pathCoding':6130,'pathEnd':2,'pathStart':5,'time':'2018/05/02 05:50','vaild':1}," +
                "{'date':'20180502','inNum':1,'inPer':'100.0%','outNum':0,'outPer':'0.0%','pathCoding':6130,'pathEnd':2,'pathStart':5,'time':'2018/05/02 05:50','vaild':1}," +
                "{'date':'20180502','inNum':1,'inPer':'100.0%','outNum':0,'outPer':'0.0%','pathCoding':6130,'pathEnd':2,'pathStart':5,'time':'2018/05/02 05:50','vaild':1}," +
                "{'date':'20180502','inNum':1,'inPer':'100.0%','outNum':0,'outPer':'0.0%','pathCoding':6130,'pathEnd':2,'pathStart':5,'time':'2018/05/02 05:50','vaild':1}," +
                "{'date':'20180502','inNum':1,'inPer':'100.0%','outNum':0,'outPer':'0.0%','pathCoding':6130,'pathEnd':2,'pathStart':5,'time':'2018/05/02 05:50','vaild':1}]," +
                "}\n";
        System.out.println(result);
    }
}
