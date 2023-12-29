package com.cc.backend;

import org.junit.jupiter.api.Test;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class Test1 {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    void test1() throws InterruptedException {

    }
}
