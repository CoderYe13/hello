package com.henu.kfk;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaSend {

    private KafkaTemplate<Integer, String> kafkaTemplate;


    public void sendMsg(String msg) {
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-kafka-producer.xml");
        kafkaTemplate = applicationContext.getBean(KafkaTemplate.class);
       //异步消息
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send("HelloWorld", msg);
        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                System.out.println("This message is send successful!");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("This message is send failure!");
            }
        });
    }
}
