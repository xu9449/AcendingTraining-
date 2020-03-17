package com.sean.debug12.model;

import com.sean.debug12.jdbc.PetJDBCDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class test {
    private static Logger logger = LoggerFactory.getLogger(PetJDBCDao.class);

    public static void main (String[] args) {

        logger.debug("Debug");
        logger.info("infor");
        logger.warn("warn");

    }
}
