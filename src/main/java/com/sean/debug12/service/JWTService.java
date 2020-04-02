//package com.sean.debug12.service;

import com.sean.debug12.model.Adopter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import javax.xml.crypto.Data;
import java.security.Key;

//@Service
//public class JWTService {
//    private Logger logger = LoggerFactory.getLogger("");
//    private final String SECRET_KEY = "seanxu-seanxu";
//    private final String ISSUER = "com.ascending";
//    private final long EXPIRATION_TIME = 86400 * 1000;
//
//    public String gerateToken(Adopter adopter) {
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//        //claim
//        Claims claims = Jwts.claims();
//        claims.setId(String.valueOf(adopter.getId()));
//        claims.setSubject(adopter.getName());
//        claims.setIssuedAt(new Data(System.currentTimeMillis()))
////        claims.setIssuedAtl
//        return null;
//    }
//
//    public void decpyToken(String token) {
//
//    }
//
//}


