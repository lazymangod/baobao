//package com.example.jms;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.rule.OutputCapture;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import javax.jms.JMSException;
//
//import static org.junit.Assert.assertTrue;
//
///**
// * Created by lazygod on 2016/8/10 ${Time}.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class JmsProducerTest {
//
//    @Rule
//    public OutputCapture outputCapture = new OutputCapture();
//
//    @Autowired
//    private JmsProducer producer;
//
//    @Test
//    public void sendSimpleMessage() throws InterruptedException, JMSException {
//
//        for (int i = 0; i < 10000; i++) {
//            this.producer.send("message id ="+i);
//        }
//
//        System.out.println(" 发送完毕**********");
//        boolean isContains = this.outputCapture.toString().contains("message");
//        assertTrue(isContains);
//
//    }
//
//
//
//}