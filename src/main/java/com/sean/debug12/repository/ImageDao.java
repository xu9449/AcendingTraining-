package com.sean.debug12.repository;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Image;
import org.springframework.stereotype.Repository;


public interface ImageDao  {
    Image save(Image image);
}
