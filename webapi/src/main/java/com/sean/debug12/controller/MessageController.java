package com.sean.debug12.controller;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.sean.debug12.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/message", "/mes", "/messages"})
public class MessageController {

    @Value("${aws.sqs.queuename}")
    private String queueName;

    @Autowired
    MessageService messageService;

    @Autowired
    AmazonSQS amazonSQS;



    @RequestMapping(value = "", method = RequestMethod.POST)
    public String sendMessage(@RequestParam(name ="message") String messageBody, @RequestParam(name="delaySec") int delaySec){
        messageService.sendMessage(messageBody, delaySec);
        return "The message: \""+messageBody+ "\"  already sended!";
    }

    public String getQueueUrl(String queueName){
        GetQueueUrlResult getQueueUrlRequest = amazonSQS.getQueueUrl(queueName);
        return getQueueUrlRequest.getQueueUrl();
    }
}
