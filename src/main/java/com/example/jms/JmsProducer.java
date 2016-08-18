//package com.example.jms;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Required;
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.jms.Queue;
//
///**
// * Created by lazygod on 2016/8/10 ${Time}.
// */
//@Component
//public class JmsProducer  {
//
//    private final JmsMessagingTemplate jmsTemplate;
//
//    private final Queue queue;
//
//    @Autowired(required = true)
//    public JmsProducer(Queue queue, JmsMessagingTemplate jmsTemplate) {
//        this.queue = queue;
//        this.jmsTemplate = jmsTemplate;
//    }
//
//    public void send(String msg) {
//        this.jmsTemplate.convertAndSend(this.queue, msg);
//    }
//
//}
