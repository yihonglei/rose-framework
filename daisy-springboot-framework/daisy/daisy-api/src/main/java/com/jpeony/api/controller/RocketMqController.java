package com.jpeony.api.controller;

import com.jpeony.common.utils.ApiResponse;
import com.jpeony.core.mq.TestRocketMqProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RocketMQ 生产者-消费者
 *
 * @author yihonglei
 */
@RestController
@RequestMapping("/rocketmq/test")
public class RocketMqController {

    @Autowired
    private TestRocketMqProducer producer;

    @GetMapping("/producer")
    public ApiResponse producer() {
        boolean b = false;
        try {
            b = producer.sendMessage("testTopic", "*", "This my rocketmq message!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ApiResponse.success(b);
    }
}
