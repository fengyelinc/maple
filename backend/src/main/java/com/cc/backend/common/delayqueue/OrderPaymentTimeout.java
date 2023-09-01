package com.cc.backend.common.delayqueue;

import com.cc.backend.common.delayqueue.RedisDelayQueueHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 订单支付超时处理
 * <p>
 */
@Slf4j
@Component
public class OrderPaymentTimeout implements RedisDelayQueueHandle<Map<String, Object>> {

    @Override
    public void execute(Map<String, Object> map) {
        // TODO-MICHAEL: 2021-04-25 订单支付超时，自动取消订单处理业务...
        log.info("收到订单支付超时延迟消息：{}", map);
    }
}
