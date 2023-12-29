package com.cc.backend.common.delayqueue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 延迟队列业务枚举
 * <p>
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RedisDelayQueue {

   PUBLISH_WORK_TIMEOUT("PUBLISH_WORK_TIMEOUT", "发布超时", "publishWorkTimeout"),

    ;

    /**
     * 延迟队列 Redis Key
     */
    private String code;

    /**
     * 中文描述
     */
    private String desc;

    /**
     * 延迟队列具体业务实现的 Bean
     * 可通过 Spring 的上下文获取
     */
    private String beanId;
}
