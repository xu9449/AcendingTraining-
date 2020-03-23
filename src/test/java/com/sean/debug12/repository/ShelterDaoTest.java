package com.sean.debug12.repository;

import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ShelterDaoTest {
    private ShelterDao shelterDao;

    private Pet p1;
    private Pet p2;
    private Shelter s1;
    private String SheString = "SHELTER1";

    @Before
    public void init() {
        shelterDao = new ShelterDaoImpl();

        s1 = new Shelter();
        s1.setName(SheString);
        s1.setLocation("Arlington");
        s1.setDescription("Very good");
        s1.setPrinciple("Sean Xu");

//        p1 = new Pet();
//        p1.setName("Alice");
//        p1.setAge("2 years");
//        p1.setShelter(s1);

    }

    @After
    public void tearDown() {

    }

    @Test
    public void getDepartmentTest() {
        List<Shelter> shelters = shelterDao.getShelters();
        int expectedNumOfShelt = 4;
        shelters.forEach(shelt -> System.out.println(shelt));
        Assert.assertEquals(expectedNumOfShelt, shelters.size());
    }
}
