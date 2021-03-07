package com.eddk.veterinaire_g10.controllers;

import com.eddk.veterinaire_g10.models.Ordonnance;
import com.eddk.veterinaire_g10.repositories.OrdonnanceRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0/ordonnances")
public class OrdonnancesController {

    @Autowired
    private OrdonnanceRepository ordonnanceRepository;

    //get all ordonnances
    @GetMapping
    public List <Ordonnance> getAllOrdonnances(){

    return this.ordonnanceRepository.findAll();
    }


    //get ordonnances by ID
    @GetMapping("/{id}")
    public Ordonnance getOrdonnanceById(@PathVariable (value = "id") Integer ordonnance_id){

        return this.ordonnanceRepository.findById(ordonnance_id).orElseThrow(() -> new ResourceNotFoundException("Ordonnance not found"));

    }


    //create ordonnance
    @PostMapping
    public Ordonnance createOrdonnance(@RequestBody Ordonnance ordonnance){

        return this.ordonnanceRepository.save(ordonnance);
    }


    //update ordonnance
    @PutMapping("/{id}")
    public Ordonnance updateOrdonnance(@RequestBody Ordonnance ordonnance, @PathVariable(value = "id") Integer ordonnance_id){

        Ordonnance existingOrdonnance = this.ordonnanceRepository.findById(ordonnance_id).orElseThrow(() -> new ResourceNotFoundException("Ordonnance not found"));

        existingOrdonnance.setRendezVous(ordonnance.getRendezVous());
        existingOrdonnance.setPrescriptions(ordonnance.getPrescriptions());

        return this.ordonnanceRepository.save(existingOrdonnance);

    }


    //delete ordonance by ID
    @DeleteMapping("/{id}")
    public void deleteOrdonnance(@PathVariable("id") Integer ordonnance_id){

        ordonnanceRepository.deleteById(ordonnance_id);

    }
}
