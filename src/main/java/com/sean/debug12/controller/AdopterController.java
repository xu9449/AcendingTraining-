package com.sean.debug12.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.model.View.PetViews;
import com.sean.debug12.model.View.ShelterViews;
import com.sean.debug12.service.AdopterService;
import com.sean.debug12.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/adopters", "/adopter"})
public class AdopterController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AdopterService adopterService;

    // http://localhost:8080/adopter GET
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Adopter> getAdopters() {
        return adopterService.getAdopters();
    }


    //http://localhost:8080/adopter/id GET
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE} )
    public Adopter getAdopterByID(@PathVariable("id") Long Id) {
        Adopter adopter = adopterService.getShelterById(Id);
        return adopter;
    }

    //http://localhost:8080/adopter?name = xxx Get
    @RequestMapping(value = "/name", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Adopter getAdopterByName(@RequestParam("name") String name){
        logger.info("pass in variable name: " + name);
        return adopterService.getAdopterByName(name);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Adopter createAdopter(@RequestBody Adopter adopter) {
        logger.debug("Adopter: " + adopter.toString());
        String msg = "The department was created.";
        Adopter adop = adopterService.save(adopter);

        if (adop == null) msg = "The adopter is not created.";
        return adop;
    }


}
