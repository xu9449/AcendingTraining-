package com.sean.debug12.controller;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Image;
import com.sean.debug12.service.FileService;
import com.sean.debug12.service.ImageService;
import com.sean.debug12.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;

@RestController
@RequestMapping(value = {"/files"})
public class FileController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileService fileService;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    @Autowired
    private ImageService imageService;

    @Autowired
    private PetService petService;


    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadFile( @RequestParam("file") MultipartFile file, ServletRequest request) {
        try{
            logger.info("test file name: " + file.getOriginalFilename());
//        HttpServletRequest request = this.
//                String token = token.replaceAll("^(.*?) ", "");
            com.sean.debug12.model.Image image = new com.sean.debug12.model.Image(file.getOriginalFilename());
            image.setFileName(file.getOriginalFilename());
            HttpServletRequest req = (HttpServletRequest) request;
            HttpSession httpSession = req.getSession();
            Adopter adopter = (Adopter) httpSession.getAttribute("adopter");
            image.setAdopter(adopter);
            String url = fileService.uploadFile(bucketName, file);
            image.setUrl(url);
            Image image2 = imageService.save(image);
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
