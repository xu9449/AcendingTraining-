package com.sean.debug12.repository;

import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;

import java.math.BigInteger;
import java.util.List;

public interface ShelterDao {

    boolean delete(Shelter shelter);
    List<Shelter> getShelters() ;
    Shelter save(Shelter shelter);
    Shelter update(Shelter shelter);
//    Shelter getShelterByName(String Name);
    Shelter getShelterEagerBy(long Id);
    Shelter getShelterBy(long Id);


}
