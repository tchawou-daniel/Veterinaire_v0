package com.eddk.veterinaire_g10.controllers;

import com.eddk.veterinaire_g10.models.Prescription;
import com.eddk.veterinaire_g10.repositories.PrescriptionRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api/v0/prescriptions/")
public class PrescriptionsController {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @GetMapping
    public List<Prescription> list() {
        return prescriptionRepository.findAll();
    }


    @GetMapping("{id}")
    public Prescription get(@PathVariable int id) {
        return prescriptionRepository.getOne(id);
    }

    @PostMapping
    public Prescription create(@RequestBody Prescription prescription) {
        return prescriptionRepository.saveAndFlush(prescription);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        prescriptionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Prescription update(@PathVariable int id, @RequestBody Prescription prescription) {
        Prescription existingPrescription = prescriptionRepository.getOne(id);
        BeanUtils.copyProperties(prescription, existingPrescription, "prescriptionid");
        return prescriptionRepository.saveAndFlush(existingPrescription);
    }


}
