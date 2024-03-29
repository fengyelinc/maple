package com.cc.backend.controller;

import com.cc.backend.common.delayqueue.RedisDelayQueue;
import com.cc.backend.common.delayqueue.RedisDelayQueueUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 延迟队列测试
 * <p>
 */
@RestController
@RequestMapping("/api/redis/delayQueue")
public class RedisDelayQueueController {

    @Autowired
    private RedisDelayQueueUtil redisDelayQueueUtil;

    @PostMapping("/add")
    public void addQueue() {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("orderId", "100");
        map1.put("remark", "订单支付超时，自动取消订单");

        Map<String, String> map2 = new HashMap<>();
        map2.put("orderId", "200");
        map2.put("remark", "订单超时未评价，系统默认好评");

        // 添加订单支付超时，自动取消订单延迟队列。为了测试效果，延迟10秒钟
        redisDelayQueueUtil.addDelayQueue(map1, 10, TimeUnit.SECONDS, RedisDelayQueue.PUBLISH_WORK_TIMEOUT.getCode());


    }
}
