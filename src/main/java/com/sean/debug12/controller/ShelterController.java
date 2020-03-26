package com.sean.debug12.controller;

import com.sean.debug12.model.Shelter;
import com.sean.debug12.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = {"/shelters", "/shelter","/shelts"})
public class ShelterController {
    @Autowired
    private ShelterService shelterService;

    // /shelters GET
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Shelter> getShelters() {

        return shelterService.getShelters();
    }

//    @RequestMapping(value = " ", method = RequestMethod.POST)
//    public List<Shelter> getShelters() {
//
//        return shelterService.getShelters();
//    }
}
