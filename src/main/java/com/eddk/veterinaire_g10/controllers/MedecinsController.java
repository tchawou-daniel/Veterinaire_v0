package com.eddk.veterinaire_g10.controllers;

import com.eddk.veterinaire_g10.exception.RessourceNotFoundException;
import com.eddk.veterinaire_g10.models.Medecin;
import com.eddk.veterinaire_g10.repositories.MedecinRepository;
import com.eddk.veterinaire_g10.repositories.MedicamentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/medecins")
public class MedecinsController {
    @Autowired
    private MedecinRepository medecinRepository;

    public MedecinsController(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    @GetMapping
    public List<Medecin> list() {
        return medecinRepository.findAll();
    }

    @RequestMapping("{id}")
    public Medecin get(@PathVariable int id) {
        return medecinRepository.getOne(id);
    }

    @PostMapping
    public Medecin create(@RequestBody Medecin medecin) {
        return medecinRepository.saveAndFlush(medecin);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        medecinRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Medecin update(@PathVariable int id, @RequestBody Medecin medecin) {
        Medecin existingMedecin = medecinRepository.getOne(id);
        BeanUtils.copyProperties(medecin, existingMedecin, "medecinid");
        return medecinRepository.saveAndFlush(existingMedecin);
    }

    @GetMapping(value = "/recherche/{recherche}")
    public List<Medecin> searchForEntity(@PathVariable String recherche) {
        return medecinRepository.findByNommedecinLike("%" + recherche + "%");
    }
}
