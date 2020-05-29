package com.sean.debug12.consumer.init;


import com.amazonaws.services.sqs.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.List;

@SpringBootApplication(scanBasePackages = {"com.sean.debug12.consumer"})
public class WorkApplication {

    //    @Value("${aws.sqs.queuename}")
    private static String queueName = "sean-sean";

    @Autowired
    static com.sean.debug12.consumer.service.EmailService emailService;

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(WorkApplication.class, args);
        com.sean.debug12.consumer.service.SQSMessageService messageService = app.getBean(com.sean.debug12.consumer.service.SQSMessageService.class);
        try {

            List<Message> messages = messageService.receiveMessage(queueName);
            for (Message m : messages) {
                emailService.processMessage(m.getBody());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}