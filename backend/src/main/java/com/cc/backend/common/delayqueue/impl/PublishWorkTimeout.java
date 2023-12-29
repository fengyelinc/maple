package com.cc.backend.common.delayqueue.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.cc.backend.common.delayqueue.RedisDelayQueueHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class PublishWorkTimeout implements RedisDelayQueueHandle<Map<String, Object>> {




    @Override
    public void execute(Map<String, Object> map) {
       // 这里处理具体的延时逻辑

    }


}
