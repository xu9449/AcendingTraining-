package com.sean.debug12.service;

import com.amazonaws.services.alexaforbusiness.AmazonAlexaForBusiness;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.sean.debug12.init.AWSConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.google.common.io.Files;

@Service
public class FileService {

    @Value("${aws.region}")
    private String defaultRegion;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    private Logger logger = LoggerFactory.getLogger(getClass());

//        public void uploadFile(File f){
////            AmazonS3 s3Client = awsConfig.getAmazonS3();
////            s3Client.putObject("sean-sean", "sampleFile4.txt", "Uploaded String");
//            PutObjectRequest request = new PutObjectRequest(bucketName, f.getName(), f);
//            s3Client.putObject(request);
//
//
//        }

    public String getUrl(String s3Key) {
        return s3Client.getUrl(bucketName, s3Key).toExternalForm();
    }

    public String uploadFile(MultipartFile file) throws IOException {
        try {
            String uuid = UUID.randomUUID().toString();
            String originalFilename = file.getOriginalFilename();
            String newFileName = Files.getNameWithoutExtension(originalFilename) + uuid + '.' + Files.getFileExtension(originalFilename);
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());
            PutObjectRequest request = new PutObjectRequest (bucketName, newFileName, file.getInputStream(), objectMetadata);
            s3Client.putObject(request.withCannedAcl(CannedAccessControlList.PublicRead));
            logger.info(String.format("The file name = %s was uploaded to bucket %s", file.getOriginalFilename(), bucketName));
            String url = s3Client.getUrl(bucketName, newFileName).toString();
            return url;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
//      s3Client.putObject(bucketName, file.getOriginalFilename(), file.getInputStream(), null);
        return null;
    }

    public String uploadFile(String bucketName, MultipartFile file) throws IOException {
//        AmazonS3 s3Client = awsConfig.getAmazonS3();
//        s3Client.putObject("sean-sean", "sampleFile4.txt", "Uploaded String");
//        PutObjectRequest request = new PutObjectRequest(bucketName, f.getName(), f);
//        s3Client.putObject(request);
        try {
            String uuid = UUID.randomUUID().toString();
            String originalFilename = file.getOriginalFilename();
            String newFileName = Files.getFileExtension(originalFilename) + uuid + '.' + Files.getFileExtension(originalFilename);
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(file.getContentType());
            objectMetadata.setContentLength(file.getSize());

            PutObjectRequest request = new PutObjectRequest (bucketName, newFileName, file.getInputStream(), objectMetadata);
            s3Client.putObject(request.withCannedAcl(CannedAccessControlList.PublicRead));

            //s3Client.putObject(bucketName, newFileName, file.getInputStream(), objectMetadata);

            logger.info(String.format("The file name = %s was uploaded to bucket %s", file.getOriginalFilename(), bucketName));
            String url = s3Client.getUrl(bucketName, newFileName).toString();
            return url;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
//      s3Client.putObject(bucketName, file.getOriginalFilename(), file.getInputStream(), null);
        return null;
    }


}
