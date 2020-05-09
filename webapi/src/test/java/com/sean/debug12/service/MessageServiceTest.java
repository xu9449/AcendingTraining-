package com.sean.debug12.service;

import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.sean.debug12.init.Appbootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Appbootstrap.class)
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @Autowired
    private AmazonSQS amazonSQS;

    @Test
    public void sendMessageTest(){

//        MultipartFile testFile2 = Mockito.mock(MultipartFile.class);
//        InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());
//
////        when(testFile.getName()).thenReturn("resume.pdf");
//        when(testFile2.getOriginalFilename()).thenReturn("resume.pdf");
//        when(testFile2.getInputStream()).thenReturn(anyInputStream);
////        file2Service.uploadFile(null);
////        verify(amazonS3client, times(0)).putObject(any(PutObjectRequest.class));
//        //fileService.uploadFile(testFile);
//        verify(amazonS3client, times(0)).putObject(any(PutObjectRequest.class));
//        //file.getInputStream()
//        fileService.uploadFile(testFile2);
////        verify(amazonS3client, times(1)).putObject(anyString(), anyString(),any(InputStream.class),any(ObjectMetadata.class));
//        verify(amazonS3client, times(1)).putObject(any(PutObjectRequest.class));
////        when(amazonSQS)
        verify(amazonSQS, times(0)).sendMessage(any(SendMessageRequest.class));
        messageService.sendMessage("Sean", 1);
        verify(amazonSQS, times(1)).sendMessage(any(SendMessageRequest.class));
    }

}
