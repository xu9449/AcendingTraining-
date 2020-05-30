package com.sean.debug12.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Value("${aws.sqs.queuename}")
    private String queueName;



    private AmazonSQS amazonSQS;

    public MessageService(@Autowired AmazonSQS amazonSQS){
        this.amazonSQS = amazonSQS;
    }

    public AmazonSQS getAmazonSQS(){
        return amazonSQS;
    }

    public void sendMessage(String messageBody, int delaySec) {
        SendMessageRequest send_msg_request = new SendMessageRequest()
                //TODO: change to constuctor injection
                .withQueueUrl(getQueueUrl(queueName))
                .withMessageBody(messageBody)
                .withDelaySeconds(delaySec);
        amazonSQS.sendMessage(send_msg_request);
    }

    public String getQueueUrl(String queueName){
        GetQueueUrlResult getQueueUrlRequest = amazonSQS.getQueueUrl(queueName);
        return getQueueUrlRequest.getQueueUrl();
    }

}
