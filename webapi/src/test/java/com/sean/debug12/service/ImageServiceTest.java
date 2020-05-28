package com.sean.debug12.service;

import com.sean.debug12.init.Appbootstrap;
import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Image;
import com.sean.debug12.repository.AdopterDao;
import com.sean.debug12.repository.ImageDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Appbootstrap.class)
@Profile("unit")
public class ImageServiceTest {

    @Autowired
    ImageDao imageDao;

    @Autowired
    AdopterDao adopterDao;

    @Test
    public void saveImageTest(){
        Image image = new Image();

        String filename = "Test01.txt";
        Long adopterId = 1L;
        image.setFileName(filename);
        Adopter adopter = adopterDao.getAdopterById(adopterId);
        image.setAdopter(adopter);
        imageDao.save(image);


    }
}
