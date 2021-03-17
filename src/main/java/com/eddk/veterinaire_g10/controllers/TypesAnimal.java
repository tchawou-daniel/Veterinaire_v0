package com.eddk.veterinaire_g10.controllers;

import com.eddk.veterinaire_g10.exception.RessourceNotFoundException;
import com.eddk.veterinaire_g10.models.Medicament;
import com.eddk.veterinaire_g10.models.TypeAnimal;
import com.eddk.veterinaire_g10.repositories.TypeAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/typesanimals")
public class TypesAnimal {
    @Autowired
    private TypeAnimalRepository typeAnimalRepository;

    @GetMapping
    public List<TypeAnimal> getAllTypeAnimal() {
        return this.typeAnimalRepository.findAll();
    }

    @GetMapping("/{id}")
    public TypeAnimal getTypeAnimalById(@PathVariable(value = "id") Integer type_animal_id) {
        return this.typeAnimalRepository.findById(type_animal_id).orElseThrow(() -> new RessourceNotFoundException("Type animal not found with id :" + type_animal_id));
    }

    @PostMapping
    public TypeAnimal createTypeAnimal(@RequestBody TypeAnimal typeAnimal) {
        return this.typeAnimalRepository.save(typeAnimal);
    }

    @PutMapping("/{id}")
    public TypeAnimal updateTypeAnimal(@RequestBody TypeAnimal typeAnimal, @PathVariable("id") Integer typeanimalid) {
        TypeAnimal existingType = this.typeAnimalRepository.findById(typeanimalid)
                .orElseThrow(() -> new RessourceNotFoundException("Type animal not found with id :" + typeanimalid));
        existingType.setLibTypeAnimal(typeAnimal.getLibTypeAnimal());
        return this.typeAnimalRepository.save(existingType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypeAnimal> deleteTypeAnimal(@PathVariable("id") Integer typeanimalid) {
        TypeAnimal existingType = this.typeAnimalRepository.findById(typeanimalid)
                .orElseThrow(() -> new RessourceNotFoundException("Type animal not found with id :" + typeanimalid));
        this.typeAnimalRepository.delete(existingType);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/recherche/{recherche}")
    public List<TypeAnimal> searchForEntity(@PathVariable String recherche) {
        return typeAnimalRepository.findByLibtypeanimalLike("%" + recherche + "%");
    }
}

