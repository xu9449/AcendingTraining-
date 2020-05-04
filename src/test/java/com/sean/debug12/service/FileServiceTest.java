package com.sean.debug12.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.sqs.AmazonSQS;
import com.sean.debug12.init.Appbootstrap;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;



import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Appbootstrap.class)
public class FileServiceTest {
    @Autowired
    private FileService fileService;

    @Autowired
    private AmazonS3 amazonS3client;


    @Test
    public void uploadFileTest() throws IOException {

        MultipartFile testFile2 = Mockito.mock(MultipartFile.class);
        InputStream anyInputStream = new ByteArrayInputStream("test data".getBytes());

//        when(testFile.getName()).thenReturn("resume.pdf");
        when(testFile2.getOriginalFilename()).thenReturn("resume.pdf");
        when(testFile2.getInputStream()).thenReturn(anyInputStream);
//        file2Service.uploadFile(null);
//        verify(amazonS3client, times(0)).putObject(any(PutObjectRequest.class));
        //fileService.uploadFile(testFile);
        verify(amazonS3client, times(0)).putObject(any(PutObjectRequest.class));
        //file.getInputStream()
        fileService.uploadFile(testFile2);
//        verify(amazonS3client, times(1)).putObject(anyString(), anyString(),any(InputStream.class),any(ObjectMetadata.class));
        verify(amazonS3client, times(1)).putObject(any(PutObjectRequest.class));
    }



    @Test
    public void getUrlTest() {

//        File testFile = Mockito.mock(File.class);
//        when(testFile.getName()).thenReturn("resume.pdf");

        String key = "qwer1234";

        //TODO: unit test no try catch
        try {
            when(amazonS3client.getUrl(anyString(), anyString())).thenReturn(new URL("http", "ascending.com", 800, "sdf.pdf"));
            String url = fileService.getUrl(key);
            verify(amazonS3client, times(1)).getUrl(anyString(),anyString());
        }catch (Exception e){

        }
    }
}

