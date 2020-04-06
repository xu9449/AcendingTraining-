package com.sean.debug12.service;

import com.sean.debug12.init.Appbootstrap;
import com.sean.debug12.model.Adopter;
//import com.sun.applet2.preloader.event.AppInitEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Appbootstrap.class)
public class JWTServiceTest {
    @Autowired
    private JWTService jwtService;


    @Test
    public void generateTokenTest() {
        Adopter adopter = new Adopter();
        adopter.setId(10);
        adopter.setName("Ryo");
        String token = jwtService.gerateToken(adopter);
//        assertNotNull(token);
        jwtService.verifyJWT(token);
    }



}
