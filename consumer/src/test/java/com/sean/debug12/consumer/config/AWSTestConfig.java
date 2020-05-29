package com.sean.debug12.consumer.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.sqs.AmazonSQS;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

@Configuration
public class AWSTestConfig {

    @Bean
    @Profile("unit")
    public AmazonSQS getAmazonSQS() {
        return mock(AmazonSQS.class);
    }

    @Bean
    @Profile("unit")
    public SendGrid getSendGridBean() throws IOException {
        SendGrid sendGridFake = Mockito.mock(SendGrid.class);
        Response fakeResponse = Mockito.mock(Response.class);
        Mockito.when(sendGridFake.api(any(Request.class))).thenReturn(fakeResponse);
        return sendGridFake;

    }
}
