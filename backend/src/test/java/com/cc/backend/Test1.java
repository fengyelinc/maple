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
        RBlockingDeque<Object> blockingDeque = redissonClient.getBlockingDeque("test1");
        RDelayedQueue<Object> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);

        for (int i = 0; i < 5; i++) {
            delayedQueue.offer("fffffffff"+i, 13, TimeUnit.SECONDS);
        }
        Thread.sleep(2000);
        new Thread(){
            @Override
            public void run() {
               while(true){
                   try {
                       System.out.println( blockingDeque.take());
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
            }
        }.start();


    }
}
