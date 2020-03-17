package com.sean.debug12.jdbc;

import com.sean.debug12.model.Adopter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AdopterJDBCDAOTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private AdopterJDBCDao adopterDao;

    @Before
    public void init() {
        adopterDao = new AdopterJDBCDao();
        long testid = 0;

    }


    @Test
    public void getAdoptersTest() {
        List<Adopter> adopters = adopterDao.getAdopter();
        int expectedNumbOfDept = 2;

        Assert.assertEquals(expectedNumbOfDept, adopters.size());

    }
}
