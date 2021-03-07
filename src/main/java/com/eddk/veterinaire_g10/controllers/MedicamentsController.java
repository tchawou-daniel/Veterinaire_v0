package com.eddk.veterinaire_g10.controllers;

import com.eddk.veterinaire_g10.repositories.MedicamentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import com.eddk.veterinaire_g10.models.Medicament;
import org.springframework.beans.BeanUtils;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/medicaments")
public class MedicamentsController {
    @Autowired
    private MedicamentRepository medicamentRepository;

    public MedicamentsController(MedicamentRepository medicamentRepository){
        this.medicamentRepository = medicamentRepository;
    }

    @GetMapping
    public List<Medicament> list() {
        return medicamentRepository.findAll();
    }

    @RequestMapping("{id}")
    public Medicament get(@PathVariable int id){
        return medicamentRepository.getOne(id);
    }

    @PostMapping
    public Medicament create(@RequestBody Medicament medicament) { return medicamentRepository.saveAndFlush(medicament); }

    @RequestMapping(value="{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable int id) {
        medicamentRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method=RequestMethod.PUT)
    public Medicament update(@PathVariable int id, @RequestBody Medicament medicament){
        Medicament existingMedicament = medicamentRepository.getOne(id);
        BeanUtils.copyProperties(medicament, existingMedicament, "medicamentid");
        return medicamentRepository.saveAndFlush(existingMedicament);
    }

    @GetMapping(value = "/recherche/{recherche}")
    public List<Medicament> searchForEntity(@PathVariable String recherche) {
        return medicamentRepository.findByNommedicamentLike("%"+recherche+"%");
    }





}
