package org.jeecg.stream.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* 使用Processor，则当前服务必须同时实现生产者和消费者，不然会报错
* MQ推送消息
*/

@Slf4j
@RestController
@EnableBinding(Processor.class)
class MQSendhanderController {

    @Autowired
    private Processor pipe;

    @GetMapping("/send")
    public void send(@RequestParam String message){
        //log.info("source 发送MQ消息 : "+message);
        pipe.output().send(MessageBuilder.withPayload(message).build());
    }

    @StreamListener(Processor.INPUT)
    public void process(String message){
        log.info(" local 接受MQ消息 : "+message);
        //System.out.println(" 处理MQ消息 : "+message);
    }
}