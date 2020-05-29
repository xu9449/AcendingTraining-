package com.sean.debug12.consumer.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SQSMessageService {

    @Value("${aws.sqs.queuename}")
    private String queueName;

    @Autowired
    AmazonSQS amazonSQS;


    public List<Message> receiveMessage(String queueURL) {
        List<Message> messages = amazonSQS.receiveMessage(queueURL).getMessages();
        return messages;
    }

    public boolean deleteMessages(String queueURL, List<Message> messages){
        int init = messages.size();
        int result = 0;
        for(Message m : messages){
            amazonSQS.deleteMessage(queueURL, m.getReceiptHandle());
            result++;
        }
        return init == result;
    }

//    public void consumeMessageFromQueue(){
//        GetQueueUrlResult queueUrl = amazonSQS.getQueueUrl(queueName);
//        ReceiveMessageResult message = amazonSQS.receiveMessage(queueUrl.getQueueUrl());
//        message.getMessages().forEach(m -> {
//            System.out.println("*****Printing message from queue*****" +m.getBody());
//            amazonSQS.deleteMessage(queueUrl.getQueueUrl(), m.getReceiptHandle());
//        });
//    }

    public String getQueueUrl(String queueName){
        GetQueueUrlResult getQueueUrlRequest = amazonSQS.getQueueUrl(queueName);
        return getQueueUrlRequest.getQueueUrl();
    }

}
