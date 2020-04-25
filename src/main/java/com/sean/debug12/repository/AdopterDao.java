package com.sean.debug12.repository;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Role;
import com.sean.debug12.model.Shelter;

import java.util.List;

public interface AdopterDao {


    Adopter save(Adopter adopter);
    boolean update(Adopter adopter);
    boolean delete(Adopter adopter);
//    Adopter deleteRole(String adopterName);

    List<Adopter> getAdopters();
    Adopter getAdopterById(long Id);
    Adopter getAdopterEagerById(long Id);
    Adopter getAdopterByName(String AdopterName);

    Adopter getAdopterByCredentials(String email, String password) throws Exception;
//    Adopter getAdopterByCredentials2(String name, String password) throws Exception;

    boolean adopt(Adopter adopter, String petName);

   // List<Adopter> getAdoptersWithChildren();





}
