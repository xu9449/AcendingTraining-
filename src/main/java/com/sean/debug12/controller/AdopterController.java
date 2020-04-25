package com.sean.debug12.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sean.debug12.model.Adopter;
import com.sean.debug12.model.Pet;
import com.sean.debug12.model.Role;
import com.sean.debug12.model.Shelter;
import com.sean.debug12.model.View.PetViews;
import com.sean.debug12.model.View.ShelterViews;
import com.sean.debug12.service.AdopterService;
import com.sean.debug12.service.PetService;
import com.sean.debug12.service.RoleService;
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

    @Autowired
    private RoleService roleService;

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
    @RequestMapping(value = {"/name"}, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Adopter getAdopterByName(@RequestParam("name") String name){
        logger.info("pass in variable name: " + name);
        Adopter adopter = adopterService.getAdopterByName(name);
        return adopter;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Adopter createAdopter(@RequestBody Adopter adopter) {
        logger.debug("Adopter: " + adopter.toString());
        String msg = "The department was created.";
        Adopter adop = adopterService.save(adopter);

        if (adop == null) msg = "The adopter is not created.";
        return adop;
    }

//    @RequestMapping(value = "/name", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE})
//    public Boolean delteRoles(@RequestParam("name") String adopterName, @RequestParam("role") String role){
//        logger.info("variable info passing in");
//        Adopter a2 = adopterService.getAdopterByName(adopterName);
//        List<Role> r1 = a2.getRoles();
////        Role r = roleService.getRoleByName(role);
//        Boolean a = adopterService.UpdateRole(adopterName, r);
//        List<Role> r2 = a2.getRoles();
//        return a;
//    }

    @RequestMapping(value = "/name", method = RequestMethod.PATCH, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Boolean delteRoles(@RequestParam("name") String adopterName, @RequestParam("Id") Long id){
        logger.info("variable info passing in");
        Adopter a2 = adopterService.getAdopterByName(adopterName);
        List<Role> r1 = a2.getRoles();
//        Role r = roleService.getRoleByName(role);
        Boolean a = adopterService.UpdateRole(adopterName, id);
        List<Role> r2 = a2.getRoles();
        return a;
    }
}
