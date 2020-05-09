package com.sean.debug12.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.model.View.PetViews;
import com.sean.debug12.model.View.ShelterViews;
import com.sean.debug12.service.PetService;
import com.sean.debug12.service.ShelterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;


@RestController
@RequestMapping(value = {"/pets", "/pet"})
public class PetController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PetService petService;

    // http://localhost:8080/pet GET
    @JsonView(PetViews.Internal.class)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Pet> getPets() {
        return petService.getPets();
    }

    //http://localhost:8080/shelter?name = xxx
    //可以加 params = {"name"}来区分
    @JsonView(PetViews.Internal.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public boolean updatePetAdoptable(@PathVariable("id") Long Id, @RequestParam(name = "adoptable") boolean adoptable) {
        logger.info("variable info passing in");
        Pet p = petService.getPetById(Id);
        p.setAdoptable(adoptable);
        boolean isSuccess = petService.update(p);
        return isSuccess;
    }


}
