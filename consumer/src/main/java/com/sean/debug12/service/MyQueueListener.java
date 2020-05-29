package com.sean.debug12.consumer.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


public class MyQueueListener implements MessageListener {
    @Override
    public void onMessage(Message message){
        try {
            System.out.println("***************Inside the receive message queue listener***************");
            System.out.println("Received: " + ((TextMessage) message).getText());
        } catch (JMSException e){
            e.printStackTrace();
        }
    }
}
