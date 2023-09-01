package com.cc.backend.common.delayqueue;

/**
 * 延迟队列执行器
 * <p>
 */
public interface RedisDelayQueueHandle<T> {

    void execute(T t);
}
