package com.sean.debug12.service;

import com.amazonaws.services.alexaforbusiness.AmazonAlexaForBusiness;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.sean.debug12.init.AWSConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class File2Service {
        private String defaultRegion ="us-east-1";
        private String bucketName = "sean-sean";

        @Autowired
        private AmazonS3 s3Client;

        public void uploadFile(File f){
//            AmazonS3 s3Client = awsConfig.getAmazonS3();
//            s3Client.putObject("sean-sean", "sampleFile4.txt", "Uploaded String");
            PutObjectRequest request = new PutObjectRequest(bucketName, f.getName(), f);
            s3Client.putObject(request);


        }

        public String getUrl(String s3Key) {
            return s3Client.getUrl(bucketName, s3Key).toExternalForm();
        }


}
