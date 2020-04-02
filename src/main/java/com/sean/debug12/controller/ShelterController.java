package com.sean.debug12.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.model.View.ShelterViews;
import com.sean.debug12.service.ShelterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = {"/shelters", "/shelter","/shelts"})
public class ShelterController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ShelterService shelterService;

    // http://localhost:8080/shelter GET
    @JsonView(ShelterViews.Public.class)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Shelter> getShelters() {
        return shelterService.getShelters();
    }

    //http://localhost:8080/shelter/id
    @JsonView(ShelterViews.Internal.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Shelter getShelterByID(@PathVariable("id") Long Id) {
        Shelter shelter = shelterService.getShelterEagerBy(Id);
        return shelter;
    }
//    //http://localhost:8080/shelter/id
//    @JsonView(ShelterViews.Internal.class)
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
//    public Shelter getShelterEagerByID(@PathVariable("id") Long Id) {
//        Shelter shelter = shelterService.getShelterEagerBy(Id);
//        return shelter;
//    }

//    //http://localhost:8080/shelter?name = xxx
//    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public Shelter getShelter(@RequestParam("name") String name){
//        logger.info("pass in variable name: " + name);
//
////        return shelterService.getShelterByName(name);
//    }

    //http://localhost:8080/shelter?name = xxx
    //可以加 params = {"name"}来区分
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Shelter updateShelterName(@PathVariable("id") Long Id, @RequestParam("name") String name) {
        logger.info("variable info passing in");
        Shelter s = shelterService.getShelterById(Id);
        s.setName(name);
        s = shelterService.update(s);
        return s;
    }



    //http://localhost:8080/shelters POST
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Shelter save(@RequestBody Shelter shelter) {
        Shelter she = shelterService.save(shelter);
        if (she == null) System.out.println("Shelter is not created");
        return she;
    }

    //{prefix}/shelters DELETE
    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("name") Shelter shelter) {
        return shelterService.delete(shelter);
    }

    //{prefix}/shelters PUT
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public Shelter update(Shelter shelter) {
        return shelterService.update(shelter);
    }
}


