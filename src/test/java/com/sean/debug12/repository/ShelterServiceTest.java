package com.sean.debug12.repository;

import com.sean.debug12.init.Appbootstrap;
import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.service.PetService;
import com.sean.debug12.service.ShelterService;
import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Appbootstrap.class)
public class ShelterServiceTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ShelterService shelterService;
    @Autowired
    private PetService petService;



    private Pet p1;
    private Pet p2;
    private Shelter s1;
    private String ShelterString = "SHELTER2";

    @Before
    public void init() {

//        shelterDao = new ShelterDaoImpl();
//        petDao = new PetDaoImpl();

        s1 = new Shelter();
        s1.setName(ShelterString);
        s1.setLocation("Arlington");
        s1.setDescription("Very good");
        s1.setPrinciple("Sean Xu");
        s1 = shelterService.save(s1);

        p1 = new Pet();
        p1.setName("Alice");
        p1.setAge("2 years");
        p1.setShelter(s1);
        petService.save(p1);

        p2 = new Pet();
        p2.setName("MoMo");
        p2.setAge("2 months");
        p2.setShelter(s1);
        petService.save(p2);



    }

    @After
    public void tearDown() {
        petService.delete(p1);
        petService.delete(p2);
        shelterService.delete(s1);

    }

    @Test
    public void getSheltersTest() {
        List<Shelter> shelters = shelterService.getShelters();
        int expectedNumOfShelt = 8;
        shelters.forEach(shelter -> System.out.println(shelter));
        Assert.assertEquals(expectedNumOfShelt, shelters.size());
    }

//    @Test
//    public void getShelterEagerByTest() {
//        Shelter shelter = shelterService.getShelterEagerBy(s1.getId());
//        assertNotNull(shelter);
//        assertEquals(shelter.getName(), s1.getName());
//        assertTrue(shelter.getPets().size() >0);
//
//    }

//    @Test(expected = HibernateException.class)
//    public void getShelterByTest() {
//        Shelter shelter = shelterService.getShelterBy(s1.getId());
//        assertNotNull(shelter);
//        assertEquals(shelter.getName(), s1.getName());
//        shelter.getPets().size();
//
//    }


}