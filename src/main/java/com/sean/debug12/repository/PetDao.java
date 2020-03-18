package com.sean.debug12.repository;

import com.sean.debug12.model.Pet;

import java.util.List;

public interface PetDao {

//    @Before
//
//
//    @Test
//    public void getPetTest() {
//        List<Pet> pets = petDao.getDepartments();
//        int expectedNumOfDept = 1;
//
//        Assert.assertEquals(expectedNumOfPet, pets.size());
//    }
    Pet save(Pet pet);
    //Pet update(Pet pet);
    //boolean delete(String petName);
    boolean delete(Pet pet);
    List<Pet> getPets();
    //List<Pet> getPetsWithChildren();
    //Pet getDepartmentByName(String petName);
    //Pet getPetAndShelterBy(String petName);
    //List<Object[]> getPetAndShelterAndAdopters(String petName);
    Pet getPetEagerBy(Integer id);


}
