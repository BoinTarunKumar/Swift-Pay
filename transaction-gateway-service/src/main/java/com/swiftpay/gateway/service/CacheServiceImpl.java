package com.swiftpay.gateway.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CacheServiceImpl
        implements CacheService {

    private final RedisTemplate<String, Object>
            redisTemplate;

    @SuppressWarnings("null")
@Override
    public Object get(String key) {

        return redisTemplate
                .opsForValue()
                .get(key);
    }

    @SuppressWarnings("null")
@Override
    public void put(
            String key,
            Object value
    ) {

        redisTemplate
                .opsForValue()
                .set(key, value);
    }
}