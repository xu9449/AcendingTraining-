package com.sean.debug12.controller;

import com.sean.debug12.model.Shelter;
import com.sean.debug12.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = {"/shelters", "/shelter","/shelts"})
public class ShelterController {
    @Autowired
    private ShelterService shelterService;

    // http://localhost:8080/shelter GET
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Shelter> getShelters() {
        return shelterService.getShelters();
    }

    @RequestMapping(value = "/Id", method = RequestMethod.GET)
    public Shelter findShelter(@PathVariable("Id") Long Id) {
        return shelterService.getShelterBy(Id);
    }

    //{prefix}/shelters POST
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Shelter save(@RequestBody Shelter shelter) {
        Shelter she = shelterService.save(shelter);
        if (she == null) System.out.println("Shelter is noe created");
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


