package com.sean.debug12.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.service.AdopterService;
import com.sean.debug12.service.JWTService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

import static org.postgresql.core.Oid.JSON;

@RestController
@RequestMapping(value = {"/auth"})
public class AuthController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AdopterService adopterService;
    @Autowired
    private JWTService jwtService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity adopterLogin(@RequestBody Adopter adopter) {
        // ResponseEntity 不仅可以返回，也可以返回customized content
        try {
            Adopter a = adopterService.getAdopterByCredentials(adopter.getEmail(), adopter.getPassword());
            if (a == null) return ResponseEntity.status(HttpServletResponse.SC_UNAUTHORIZED).build();
            String token = jwtService.generateToken(a);
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", token);
            return ResponseEntity.ok().body(tokenMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();

    }
}
