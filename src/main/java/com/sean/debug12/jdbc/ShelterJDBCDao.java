package com.sean.debug12.jdbc;

import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShelterJDBCDao {

    static final String DBURL = "jdbc:postgresql://localhost:5430/dealer2";
    static final String USER = "admin";
    static final String PASS = "password";

    private static Logger logger = LoggerFactory.getLogger(PetJDBCDao.class);


//    public static void main (String[] args) {
//        PetJDBCDao petJDBCDdao = new PetJDBCDao();
//        System.out.println(petJDBCDdao.getPet());
//        logger.debug("Debug");
//        logger.info("infor");
//        logger.warn("warn");
//
//    }
    public List<Shelter> getShelters() {

        List<Shelter> shelters = new ArrayList();


        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM shelter";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
//        private Long id;
//        private String name;
//        private String tel;
//        private String email;
//        private String location;
//        private String description;
//        private String principle;
            while (rs.next()) {
                //Retrieve by column name
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String tel= rs.getString("tel");
                String description = rs.getString("description");
                String email = rs.getString("email");
                String location = rs.getString("location");
                String principle = rs.getString("principle");


                //Fill the object
                Shelter shelter = new Shelter();
                shelter.setId(id);
                shelter.setName(name);
                shelter.setTel(tel);
                shelter.setLocation(location);
                shelter.setEmail(email);
                shelter.setDescription(description);
                shelter.setPrinciple(principle);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //STEP 6: finally block used to close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return shelters;
    }

}
