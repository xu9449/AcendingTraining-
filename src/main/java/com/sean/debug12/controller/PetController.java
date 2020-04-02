package com.sean.debug12.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.model.View.PetViews;
import com.sean.debug12.model.View.ShelterViews;
import com.sean.debug12.service.PetService;
import com.sean.debug12.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = {"/pets", "/pet"})
public class PetController {
    @Autowired
    private PetService petService;

    // http://localhost:8080/pet GET
    @JsonView(PetViews.Internal.class)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Pet> getPets() {
        return petService.getPets();
    }
}
