package com.sean.debug12.service;

import com.sean.debug12.init.Appbootstrap;
import com.sean.debug12.model.Adopter;
//import com.sun.applet2.preloader.event.AppInitEvent;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Appbootstrap.class)
public class JWTServiceTest {
    @Autowired
    private JWTService jwtService;

//
//    @Test
//    public void generateTokenTest() {
//        Adopter adopter = new Adopter();
//        adopter.setId(();
//        adopter.setName("Ryo");
//        String token = jwtService.gerateToken(adopter);
////        assertNotNull(token);
//        jwtService.decryptJWTToken(token);
//    }

//    @Test
//    public void decryptJwtTokenTest() {
//        Adopter adopter = new Adopter();
//        adopter.setId(10);
//        adopter.setName("Ryo");
//        String token = jwtService.gerateToken(adopter);
//
//        Claims claims = Jwts.parser()
//                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
//                .parseClaimsJws(jwt).getBody();
//
//        int id = Integer.parseInt(claims.getId());
//        boolean isValidId = id < 50;
//        String Issuer = claims.getIssuer();
//        boolean isValidIssuer = Issuer.equals("com.ascending");
//        Date expirationDate = claims.getExpiration();
//        Date deadline = new Date(2020, 12, 31);
//
//        System.out.println("=========================" + "Token Validation" + "=========================");
//        System.out.println("ID is valid: " + isValidId);
//        System.out.println("Issuer: " + isValidIssuer);
//        if(expirationDate.compareTo(deadline) >= 0) {
//            System.out.println("This token is expired");
//        } else if (expirationDate.compareTo(deadline) < 0) {
//            System.out.println("This token is sill valid");
//        }
//        System.out.println("=========================" + "Token Validation" + "=========================");
//    }



}
