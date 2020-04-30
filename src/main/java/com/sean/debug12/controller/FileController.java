package com.sean.debug12.controller;

import com.sean.debug12.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

@RestController
@RequestMapping(value = {"/files"})
public class FileController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        logger.info("test file name: " + file.getOriginalFilename());
        try {
            String url = fileService.uploadFile("sean-sean", file);
            System.out.println(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
