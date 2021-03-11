//package org.jeecg.stream.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.Output;
//import org.springframework.cloud.stream.messaging.Source;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.support.MessageBuilder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
///**
//* MQ推送消息(当前服务只生产消息)
//*/
//@RestController
//@EnableBinding(Source.class)
//public class MQSendController {
//
//    @Autowired
//    @Output(Source.OUTPUT)
//    private MessageChannel channel;
//
//    @GetMapping("/send")
//    public void send(@RequestParam String message){
//        channel.send(MessageBuilder.withPayload(message).build());
//    }
//}