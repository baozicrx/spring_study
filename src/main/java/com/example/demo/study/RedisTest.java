package com.example.demo.study;


import com.example.demo.dto.PrefixStringKeySerializer;
import com.example.demo.dto.RedisKeyPrefixProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

/**
 * @Description:
 * @Author: crx
 * @Create: 14:48 2020/4/14
 */
public class RedisTest {
    public static void main(String[] args) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 支持key前缀设置的key Serializer
        redisTemplate.setKeySerializer(new PrefixStringKeySerializer(new RedisKeyPrefixProperties()));
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

    }
}
