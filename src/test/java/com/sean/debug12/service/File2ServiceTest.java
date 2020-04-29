package com.sean.debug12.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.sean.debug12.init.Appbootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.File;
import java.net.URL;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Appbootstrap.class)
//public class File2ServiceTest {
//    @Autowired
//    private FileService file2Service;
//
//    @Autowired
//    private AmazonS3 amazonS3client;
//
//    @Test
//    public void uploadFileTest(){
////        AmazonS3 s3Client = Mockito.mock(AmazonS3.class);
////        s3Client.putObject("xxx", "xxxxxxx","xxxxxx");
////        verify(s3Client, times(1)).putObject(anyString(), anyString(), anyString());//File testFile = new File("/Users/xukexin/Downloads/resume.pdf");
//
//        File testFile = Mockito.mock(File.class);
//        when(testFile.getName()).thenReturn("resume.pdf");
////        file2Service.uploadFile(null);
////        verify(amazonS3client, times(0)).putObject(any(PutObjectRequest.class));
//        file2Service.uploadFile(testFile);
//        verify(amazonS3client, times(1)).putObject(any(PutObjectRequest.class));
//
////        file2Service.uploadFile(testFile);
//    }
//
//    @Test
//    public void getUrlTest() {
//
////        File testFile = Mockito.mock(File.class);
////        when(testFile.getName()).thenReturn("resume.pdf");
//
//        String key = "qwer1234";
//        try {
//            when(amazonS3client.getUrl(anyString(), anyString())).thenReturn(new URL("http", "ascending.com", 800, "sdf.pdf"));
//            String url = file2Service.getUrl(key);
//            verify(amazonS3client, times(1)).getUrl(anyString(),anyString());
//        }catch (Exception e){
//
//        }
//    }
//}
