package com.sean.debug12.repository;

import com.sean.debug12.model.Adopter;

import java.util.List;

public interface AdopterDao {
    boolean save(Adopter adopter, String petName);
    List<Adopter> getAdopters();
    Adopter getAdopterById(int Id);


}
