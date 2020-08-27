package com.example.demo.study;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: RSA加解密工具类
 * @Author: crx
 * @Create: 9:01 2020/5/19
 */
public class RSAUtil {
    public static final String PRIVARYKEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMeUUY3VbUeOmWSG0JWNp7j/67qL\n" +
            "/XTKb45jpjM3tg2TNEq+DJJPuQ6h72qasfr+ADSetuHRJFA9CH5uOpRethxf9mgN3fCIRIrzb4KK\n" +
            "PJnEoN0jO6a12INVuNFAreNOH7IREC+oRRbWvYs9CslBvVNKR1j0HEGqNcAAQ6NSn7rzAgMBAAEC\n" +
            "gYB9qTVwSGF2HKMYWIocoARqxzh1TI9ZadyzmqqatQk7ouPZ66+er/Ok8vD7/krx7dvTRduAc16Z\n" +
            "5tPiRyU7JiciuL5osMEsSGRXqSKoEtptGffPFfSUONNnswcA3IaBP5sRurVx9fuNmBpAo6dMGlVQ\n" +
            "/HYClGZAcsTR9vyzo5QOgQJBAPdKN3lgoB5J3tEHc0ng4n7muqWW4ctD/hgcPx51ZZGvjr+MUB4v\n" +
            "GAjenF+vuKdTHZqCQGeE/gFuz1HO5A8EOlUCQQDOm+bVJeGtE8kiin8WQU/peyVItqw3Q2tLBSuS\n" +
            "o+hn/OKQGxJj+/dWNbv0oiONZw/0nX7sn3kbMeqnBQKQF3gnAkA7ujQ938WsqyDjEc6ZuHRcPDQ2\n" +
            "jIPKyYhUoHXqUGaQ0ntC7ovnTm6ardHNFq8d0uhiijUuC6QiCnaOhs70hYvlAkAxoXO22g23JNyZ\n" +
            "JonWz8Ohg4p2SCNgdxqL/+byp9sJN8847LfjOsC0fd3zqws9SXekvDykHL7b0IbcrjBqaqjbAkEA\n" +
            "h9QFMhZ9kFPi+CtL4x4CSzp7B9+ednibn8yug5780M0nRP75/ca1mzl0Bon5EIuhknPZfwXEHdGr\n" +
            "2DvM1imJdQ==";

    public static final String PUBLICKEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHlFGN1W1HjplkhtCVjae4/+u6i/10ym+OY6Yz\n" +
            "N7YNkzRKvgyST7kOoe9qmrH6/gA0nrbh0SRQPQh+bjqUXrYcX/ZoDd3wiESK82+CijyZxKDdIzum\n" +
            "tdiDVbjRQK3jTh+yERAvqEUW1r2LPQrJQb1TSkdY9BxBqjXAAEOjUp+68wIDAQAB";

    /**
     * RSA私钥解密
     *
     * @param str        : 加密后的字符串
     * @param privateKey : 解密后的字符串
     */
    public static String decrypt(String str, String privateKey) throws Exception {

        //64位解码加密后的字符串
        byte[] inputStr = new BASE64Decoder().decodeBuffer(new String(str.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
        //base64解码的私钥
        byte[] decode = new BASE64Decoder().decodeBuffer(privateKey);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decode);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(keySpec);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputStr), StandardCharsets.UTF_8);
        return outStr;
    }

    /**
     * 公钥加密
     *
     * @Param str : 加密字符串
     * @Param publicKey : 公钥
     * return : 密文
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = new BASE64Decoder().decodeBuffer(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decoded);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(keySpec);
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = new BASE64Encoder().encode(cipher.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        return outStr;
    }

    /**
     * 把原始字符串分割成指定长度的字符串列表
     *
     * @param inputString 原始字符串
     * @param length      指定长度
     * @param size        指定列表大小
     * @return
     */
    public static List<String> getStrList(String inputString, int length, int size) {
        List<String> list = new ArrayList<String>();
        size = inputString.length() / length;
        if (inputString.length() % length != 0) {
            size += 1;
        }
        int len = inputString.length();
        for (int index = 0; index < size; index++) {
            String childStr = "";
            if (index != size - 1) {
                childStr = inputString.substring(index * length, (index + 1) * length);

            } else {
                childStr = inputString.substring(index * length, inputString.length() - 1);
            }
            System.out.println(childStr);
            list.add(childStr);
        }
        return list;
    }

    public static void main(String[] args) throws Exception {

        //参数电话号码
        String msisdns = "18761858773";
        //参数短信内容
        String smsContent = "您好！恭喜您中奖了,请在任意空闲的时间前往XXXXX领取大奖，谢谢您的惠顾，祝您生活愉快~";
        //解密字数限制所以先奖需要加密的字符串分段
        //按每40个字进行分段
        List<String> li = getStrList(smsContent, 40, 0);

        //定义加密短信信息list
        List<String> enmsg = new ArrayList<>();
        //定义解密短信信息list
        List<String> demsg = new ArrayList<>();
        //对每段短信信息进行加密并形成集合 enmsg list
        for (String l : li) {
            String msg = encrypt(l.toString(), PUBLICKEY);
            enmsg.add(msg);
            //   System.out.println("加密"+msg);
        }
        System.out.println("加密" + JSONArray.toJSONString(enmsg));
        for (String s : enmsg) {
            System.out.println("加密分段" + s);
        }
        //由于解密字符也同样有限制，所以同样将分段的加密信息进行解密
        //对每段加密短信信息进行解密密并形成集合 demsg list
//        for (String l : enmsg) {
//            String msg = decrypt(l, PRIVARYKEY);
//            demsg.add(msg);
//              System.out.println("解密"+msg);
//        }
//        System.out.println("解密" + demsg);
//        System.out.println(demsg.get(0));
//        System.out.println(demsg.get(1));
//        System.out.println(decrypt("MgbK0d7b7tVvlN4f2zec908jn3kEZJRDEQDm+xSI4RAom02bsE7aVf6V7I4CQoNswd6S0LP3o92QZRt36fhsHh9n6wEuOWiatqwO8+0EFcDG6sOzmctZdNhQeAmQcpaHShh935CyU2QWy3xjbabt6G8asequAuJba6PFEvsiCBY=",PRIVARYKEY));

        String url = "http://api.jszhdc.cn:50018";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("app_id", "121000000115");
        jsonObject.put("process_code", "sendDmpMsg");
        jsonObject.put("msisdns", "['MpumcWh5QUXhnl9YEV95ZBD8iCTUJNuEnH5nxrB8iD8I4jF6n3VtU23NQJJsFYZSVPD27lREbOnMbLe5pLEmURSA4hXuYXDyoOEr3O3Dj70x78ZfakxYOUNfW+StyeYLqnrYN/Q4v31aKugfC47pgCfkyt6hoEDtW1d3i9S5bFI=']");
        jsonObject.put("msisdnType", "1");
        jsonObject.put("smsContent", JSONArray.toJSONString(enmsg));
        jsonObject.put("channelId", "302");
        System.out.println(jsonObject);
        String body1 = HttpUtil.createPost(url).body(jsonObject.toJSONString()).execute().charset("UTF-8").body();
        System.out.println(body1);
    }
}
