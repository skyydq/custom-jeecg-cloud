package org.jeecg.stream.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

/**
* MQ接受消息
*/
@Slf4j
@Component
@EnableBinding(Sink.class)
public class MyMQDemoReciver {

    @StreamListener(Processor.INPUT)
    public void process(String message){
        log.info(" client 接受MQ消息 : "+message);
        //System.out.println("处理MQ消息 : "+message);
    }
}