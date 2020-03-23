package com.sean.debug12.repository;

import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;
import org.hibernate.LazyInitializationException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class ShelterDaoTest {

    private ShelterDao shelterDao;
    private PetDao petDao;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private Pet p1;
    private Pet p2;
    private Shelter s1;
    private String ShelterString = "SHELTER1";

    @Before
    public void init() {
        shelterDao = new ShelterDaoImpl();
        petDao = new PetDaoImpl();
        s1 = new Shelter();
        s1.setName(ShelterString);
        s1.setLocation("Arlington");
        s1.setDescription("Very good");
        s1.setPrinciple("Sean Xu");
        s1 = shelterDao.save(s1);

        p1 = new Pet();
        p1.setName("Alice");
        p1.setAge("2 years");
        p1.setShelter(s1);
        petDao.save(p1);

        p2 = new Pet();
        p2.setName("MoMo");
        p2.setAge("2 months");
        p2.setShelter(s1);
        petDao.save(p2);



    }

    @After
    public void tearDown() {
        petDao.delete(p1);
        petDao.delete(p2);
        shelterDao.delete(s1);

    }

    @Test
    public void getSheltersTest() {
        List<Shelter> shelters = shelterDao.getShelters();
        int expectedNumOfShelt = 6;
        shelters.forEach(shelter -> System.out.println(shelter));
        Assert.assertEquals(expectedNumOfShelt, shelters.size());
    }

    @Test
    public void getShelterEagerByTest() {
        Shelter shelter = shelterDao.getShelterEagerBy(s1.getId());
        assertNotNull(shelter);
        assertEquals(shelter.getName(), s1.getName());
        assertTrue(shelter.getPets().size() >0);

    }

//    @Test(expected = LazyInitializationException.class)
//    public void getShelterByTest() {
//        Shelter shelter = shelterDao.getShelterBy(s1.getId());
//        assertNotNull(shelter);
//        assertEquals(shelter.getName(), s1.getName());
//        shelter.getPets().size();
//
//    }


}
