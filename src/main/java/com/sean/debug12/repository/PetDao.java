package com.sean.debug12.repository;

import com.sean.debug12.model.Pet;

import java.util.List;

public interface PetDao {

    boolean save(Pet pet);
    //Pet update(Pet pet);
    //boolean delete(String petName);
    boolean delete(Pet pet);
    boolean update(String name, boolean adoptable);
    List<Pet> getPets();
    Pet getPetByName(String petName);



}
