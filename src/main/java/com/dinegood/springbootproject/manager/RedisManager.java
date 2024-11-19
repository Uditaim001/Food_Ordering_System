package com.dinegood.springbootproject.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
@Component
public class RedisManager {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    public void storeItemInRedis(String key, Object item) {
        redisTemplate.opsForValue().set(key, item, 10, TimeUnit.MINUTES); // Set a 10-minute expiration
    }

    // Get an item from Redis
    public Object getItemFromRedis(String key) {
        return redisTemplate.opsForValue().get(key);
    }
    public boolean containsKey(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }
}
