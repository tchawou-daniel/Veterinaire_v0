package com.eddk.veterinaire_g10.controllers;


import java.util.List;
import java.util.Optional;

import com.eddk.veterinaire_g10.exception.RessourceNotFoundException;
import com.eddk.veterinaire_g10.models.*;
import com.eddk.veterinaire_g10.repositories.TypeAnimalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eddk.veterinaire_g10.repositories.ParentRepository;

@RestController
@RequestMapping("/api/v0/parents")
public class ParentsController {
    @Autowired
    private ParentRepository parentRepository;

    // get all parent animal
    @GetMapping
    public List<Parent> getAllParents() {
        return this.parentRepository.findAll();
    }

    @GetMapping("{id}")
    public Parent get(@PathVariable int id) {
        return parentRepository.getOne(id);
    }


    @PostMapping
    public Parent create(@RequestBody Parent parent) {
        return parentRepository.saveAndFlush(parent);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        parentRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Parent update(@PathVariable int id, @RequestBody Parent parent) {

        Parent existingParent = parentRepository.getOne(id);
        System.out.println(existingParent.getTypeparent().compareTo("FEMME"));
        System.out.println(existingParent.getTypeparent().compareTo("HOMME"));
        System.out.println(!(existingParent.getTypeparent().compareTo("FEMME")==0 || existingParent.getTypeparent().compareTo("HOMME")==0));

        if(!(existingParent.getTypeparent().compareTo("FEMME")==0 || existingParent.getTypeparent().compareTo("HOMME")==0)) {
            java.lang.System.exit(-1);
        }
        BeanUtils.copyProperties(parent, existingParent, "parentid");
        return parentRepository.saveAndFlush(existingParent);

    }


    @GetMapping(value = "/recherche/{recherche}")
    public List<Parent> searchForEntity(@PathVariable String recherche) {
        return parentRepository.findByNomparentLike("%" + recherche + "%");
    }
}
