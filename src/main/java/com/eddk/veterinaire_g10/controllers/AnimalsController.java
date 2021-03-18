package com.eddk.veterinaire_g10.controllers;

import java.util.List;
import java.util.Optional;

import com.eddk.veterinaire_g10.exception.RessourceNotFoundException;
import com.eddk.veterinaire_g10.models.Medecin;
import com.eddk.veterinaire_g10.models.TypeAnimal;
import com.eddk.veterinaire_g10.repositories.MedecinRepository;
import com.eddk.veterinaire_g10.repositories.TypeAnimalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eddk.veterinaire_g10.models.Animal;
import com.eddk.veterinaire_g10.repositories.AnimalRepository;

@RestController
@RequestMapping("/api/v0/animals")
public class AnimalsController {
    @Autowired
    private AnimalRepository animalRepository;

    public AnimalsController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @GetMapping
    public List<Animal> list() {
        return animalRepository.findAll();
    }

    @RequestMapping("{id}")
    public Animal get(@PathVariable int id) {
        return animalRepository.getOne(id);
    }

    @PostMapping
    public Animal create(@RequestBody Animal animal) {
        return animalRepository.saveAndFlush(animal);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        animalRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Animal update(@PathVariable int id, @RequestBody Animal animal) {
        Animal existingAnimal = animalRepository.getOne(id);
        BeanUtils.copyProperties(animal, existingAnimal, "animalid");
        return animalRepository.saveAndFlush(existingAnimal);
    }

    @GetMapping(value = "/recherche/{recherche}")
    public List<Animal> searchForEntity(@PathVariable String recherche) {
        return animalRepository.findByNomanimalLike("%" + recherche + "%");
    }

}
