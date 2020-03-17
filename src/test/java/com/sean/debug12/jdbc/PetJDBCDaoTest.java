package com.sean.debug12.jdbc;

import com.sean.debug12.model.Pet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;



public class PetJDBCDaoTest {

    private static Logger logger = LoggerFactory.getLogger(PetJDBCDao.class);



    private PetJDBCDao petDao;

    @Before
    public void init() {
        petDao = new PetJDBCDao();
        long testid = 0;

    }


    @Test
    public void getPetsTest() {
        List<Pet> pets = petDao.getPet();
        int expectedNumbOfDept = 2;

        Assert.assertEquals(expectedNumbOfDept, pets.size());

    }

    public static void main (String[] args) {

        logger.debug("Debug");
        logger.info("infor");
        logger.warn("warn");

    }

}
