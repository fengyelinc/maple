package com.cc.backend.common.delayqueue;



import com.cc.backend.common.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 创建延迟队列消费线程
 * <p>
 * Created by michael on 2021-04-25.
 */
@Slf4j
@Component
public class RedisDelayQueueRunner implements CommandLineRunner {

    @Autowired
    private RedisDelayQueueUtil redisDelayQueueUtil;

    @Autowired
    private SpringUtil springUtil;

    /**
     * 启动延迟队列
     *
     * @param args
     */
    @Override
    public void run(String... args) {
        new Thread(() -> {
            while (true) {
                try {
                    RedisDelayQueue[] queues = RedisDelayQueue.values();
                    for (RedisDelayQueue queue : queues) {
                        Object o = redisDelayQueueUtil.getDelayQueue(queue.getCode());
                        if (null != o) {
                            //执行延时逻辑
                            RedisDelayQueueHandle redisDelayQueueHandle = springUtil.getBean(queue.getBeanId());
                            redisDelayQueueHandle.execute(o);
                        }
                    }
                } catch (InterruptedException e) {
                    log.error("Redis延迟队列异常中断：{}", e.getMessage());
                }
            }
        }).start();
        log.info("Redis延迟队列启动成功");
    }
}

