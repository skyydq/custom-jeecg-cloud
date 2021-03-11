//package org.jeecg.stream.handler;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Processor;
//import org.springframework.stereotype.Component;
//
///**
//* MQ接受消息（示例代码）
//*/
//@Slf4j
//@Component
//public class MyMQReciver {
//
//    @StreamListener(Processor.INPUT)
//    public void process(String message){
//        log.info("接受MQ消息 : "+message);
//        System.out.println("处理MQ消息 : "+message);
//    }
//}