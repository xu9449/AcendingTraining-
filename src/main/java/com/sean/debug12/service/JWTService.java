package com.sean.debug12.service;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
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
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JWTService {

    private Logger logger = LoggerFactory.getLogger("");
    private final String SECRET_KEY = "seanxu-seanxu";
    private final String ISSUER = "com.ascending";
    private final long EXPIRATION_TIME = 86400 * 1000;

    public String gerateToken(Adopter adopter) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //claim
        Claims claims = Jwts.claims();
        claims.setId(String.valueOf(adopter.getId()));
        //claims.setSubject(adopter.getName());
        claims.setIssuedAt(new Date(System.currentTimeMillis()));
        claims.setIssuer(ISSUER);
        claims.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME));

        List<Role> roles = adopter.getRoles();

        String allowedReadResources = "";
        String allowedCreateResources = "";
        String allowedUpdateResources = "";
        String allowedDeleteResources = "";
        String allowedResource = roles.stream().map(role -> role.getAllowedResource()).collect(Collectors.joining(","));
        claims.put("allowedResource", allowedResource);
        for (Role role : roles) {
            if (role.isAllowedRead()) allowedReadResources = String.join(role.getAllowedResource(), allowedReadResources, ",");
            if (role.isAllowedCreate()) allowedCreateResources = String.join(role.getAllowedResource(), allowedCreateResources, ",");
            if (role.isAllowedUpdate()) allowedUpdateResources = String.join(role.getAllowedResource(), allowedUpdateResources, ",");
            if (role.isAllowedDelete()) allowedDeleteResources = String.join(role.getAllowedResource(), allowedDeleteResources, ",");
        }
        claims.put("allowedReadResources", allowedReadResources.replaceAll(".$", ""));
        claims.put("allowedCreateResources", allowedCreateResources.replaceAll(".$", ""));
        claims.put("allowedUpdateResources", allowedUpdateResources.replaceAll(".$", ""));
        claims.put("allowedDeleteResources", allowedDeleteResources.replaceAll(".$", ""));
        //claims.setIssuedAtl
        // Set the JWT Claims
        JwtBuilder builder = Jwts.builder().setClaims(claims).signWith(signatureAlgorithm, signingKey);
        return builder.compact();
    }

    public Claims decryptJWTToken(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(jwt).getBody();


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

        return claims;

    }


    public void decpyToken(String token) {

    }

}


