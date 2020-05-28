package com.sean.debug12.service;

import com.sean.debug12.model.Image;
import com.sean.debug12.repository.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    ImageDao imageDao;
    public Image save(Image image){
        return imageDao.save(image);
    }
}
