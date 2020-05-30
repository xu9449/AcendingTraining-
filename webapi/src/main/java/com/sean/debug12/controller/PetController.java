package com.sean.debug12.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sean.debug12.model.Adopter;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    public ResponseEntity updatePetAdoptable(@PathVariable("id") Long Id, @RequestParam(name = "adoptable") boolean adoptable, ServletRequest request) {
        logger.info("variable info passing in");
        Pet p = petService.getPetById(Id);
        String result;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession httpSession = req.getSession();
        Adopter adopter = (Adopter) httpSession.getAttribute("adopter");
        if(!adoptable){
            p.setAdoptDate(new Timestamp(System.currentTimeMillis()));
            result = p.getName()+ "is sucessfully adopted by ";
        } else {
            result = p.getName() + "is sucessfuly back to our place by ";
            p.setAdoptDate(null);
        }
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("dd MMM YYY, HH:mm");
        result = result + adopter.getName() + " on " + format.format(ts);
        p.setAdoptable(adoptable);
        boolean isSuccess = petService.update(p);
        return ResponseEntity.ok().body(result);

    }


}
