package com.cc.backend.common.delayqueue;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 封装 Redis 延迟队列工具
 * <p>
 * Created by michael on 2021-04-25.
 */
@Slf4j
@Component
public class RedisDelayQueueUtil {

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 添加延迟队列
     *
     * @param t
     * @param delay
     * @param timeUnit
     * @param queueCode
     * @param <T>
     */
    public <T> void addDelayQueue(T t, long delay, TimeUnit timeUnit, String queueCode) {
        try {
            RBlockingDeque<Object> blockingDeque = redissonClient.getBlockingDeque(queueCode);
            RDelayedQueue<Object> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
            delayedQueue.offer(t, delay, timeUnit);
            log.info("添加延时队列成功，队列键：{}，队列值：{}，延迟时间：{}", queueCode, t, timeUnit.toSeconds(delay) + "秒");
        } catch (Exception e) {
            log.error("添加延时队列失败：{}", e.getMessage());
            throw new RuntimeException("添加延时队列失败");
        }
    }

    /**
     * 获取延迟队列
     *
     * @param queueCode
     * @param <T>
     * @return
     * @throws InterruptedException
     */
    public <T> T getDelayQueue(String queueCode) throws InterruptedException {
        RBlockingDeque<Map> blockingDeque = redissonClient.getBlockingDeque(queueCode);
        T value = (T) blockingDeque.poll();
        return value;
    }
}
