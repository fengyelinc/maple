package com.cc.backend.common.delayqueue;

import com.cc.backend.common.delayqueue.RedisDelayQueueHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 订单超时未评价处理
 * <p>
 * Created by michael on 2021-04-25.
 */
@Slf4j
@Component
public class OrderTimeoutNotEvaluated implements RedisDelayQueueHandle<Map<String, Object>> {

    @Override
    public void execute(Map<String, Object> map) {
        // TODO-MICHAEL: 2021-04-25 订单超时未评价，系统默认好评处理业务...
        log.info("收到订单超时未评价延迟消息：{}", map);
    }
}

