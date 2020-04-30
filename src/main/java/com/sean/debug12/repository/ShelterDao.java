package com.sean.debug12.repository;

import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;

import java.math.BigInteger;
import java.util.List;

public interface ShelterDao {

    Shelter save(Shelter shelter);

    Boolean update(Shelter shelter);

    boolean delete(Shelter shelter);

    List<Shelter> getShelters();
    //List<Shelter> getSheltersWithChildren();


    Shelter getShelterEagerBy(long Id);

    Shelter getShelterBy(long Id);

    Shelter getShelterByName(String sheltName);


    List<Object[]> getShelterAndPets(String sheltName);

    List<Object[]> getShelterAndPetsAndAdopters(String sheltName);


}
