package com.sean.debug12.repository;

import com.sean.debug12.jdbc.PetJDBCDao;
import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PetDaoTest {

    private static Logger logger = LoggerFactory.getLogger(PetJDBCDao.class);



    private PetDao petDao;
    private Pet p1;
    private Pet p2;
    private Shelter s1;
    private String petString = "Lily";

    @Before
    public void init() {
        petDao = new PetDaoImpl();
        p1 = new Pet();
        p1.setName(petString);
        p1.setAge("Less than one year");
        p1.setBreed("Kogi");
        p1 = petDao.save(p1);


    }


    @After
    public void tearDown() {
        petDao.delete(p1);
    }

    @Test
    public void getPetsTest() {
        List<Pet> pets = petDao.getPets();
        int expectedNumbOfPet = 2;

        Assert.assertEquals(expectedNumbOfPet, pets.size());

    }

    @Test
    public void getPetByNameTest(){

    }



    public static void main (String[] args) {

        logger.debug("Debug");
        logger.info("infor");
        logger.warn("warn");

    }


}
