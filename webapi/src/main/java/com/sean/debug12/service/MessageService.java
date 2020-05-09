package com.sean.debug12.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    //    @Value("${aws.sqs.name}")
    private String queueUrl = ("https://sqs.us-east-1.amazonaws.com/646525012176/sean-sean");

    @Autowired
    private AmazonSQS sqs;

    public void sendMessage(String messageBody, int delaySec) {
        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(messageBody)
                .withDelaySeconds(delaySec);
        sqs.sendMessage(send_msg_request);

    }
}
