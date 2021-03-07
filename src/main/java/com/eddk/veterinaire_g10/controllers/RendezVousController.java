package com.eddk.veterinaire_g10.controllers;

import com.eddk.veterinaire_g10.models.Prescription;
import com.eddk.veterinaire_g10.models.RendezVous;
import com.eddk.veterinaire_g10.models.TypeAnimal;
import com.eddk.veterinaire_g10.repositories.OrdonnanceRepository;
import com.eddk.veterinaire_g10.repositories.RendezvousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v0/rendezvous")
public class RendezVousController {

    @Autowired
    private RendezvousRepository rendezvousRepository;

    //get all rdv
    @GetMapping
    public List<RendezVous> getRendezVous() {

        return this.rendezvousRepository.findAll();
    }

    //get rdv by ID
    @GetMapping("/{id}")
    public RendezVous getRendezVousById(@PathVariable(value = "id") Integer rdvid){
        return this.rendezvousRepository.findById(rdvid).orElseThrow(() -> new ResourceNotFoundException("Rendez-vous not found"));
    }


    @PostMapping
    public RendezVous create(@RequestBody RendezVous rendezvous) {
        RendezVous rdvd = null;
        RendezVous rdvhd = null;
        RendezVous rdvhf = null;
        try {
            rdvd = rendezvousRepository.findByDaterdvLike(rendezvous.getDateRdv());
            rdvhd = rendezvousRepository.findByHeuredebutrdvLike(rendezvous.getHeureDebutRdv());
            rdvhf= rendezvousRepository.findByHeurefinrdvLike(rendezvous.getHeureFinRdv());
            if(rdvd==null && rdvhd==null && rdvhf==null){
                return rendezvousRepository.saveAndFlush(rendezvous);
            }
        }catch (Exception e){
            System.out.println("le rendez-vous à cette période n'est pas dispo");
        }

        return null;
    }




    //update rdv
    @PutMapping("/{id}")
    public RendezVous updateRendezVous(@RequestBody RendezVous rendezVous, @PathVariable(value = "id") Integer rdv_id){

        RendezVous existingRendezVous = this.rendezvousRepository.findById(rdv_id).orElseThrow(() -> new ResourceNotFoundException("Rendez-vous not found"));

        existingRendezVous.setAnimal(rendezVous.getAnimal());
        existingRendezVous.setDateRdv(rendezVous.getDateRdv());
        existingRendezVous.setHeureDebutRdv(rendezVous.getHeureDebutRdv());
        existingRendezVous.setHeureFinRdv(rendezVous.getHeureFinRdv());
        existingRendezVous.setMedecin(rendezVous.getMedecin());
        existingRendezVous.setOrdonnances(rendezVous.getOrdonnances());

        return this.rendezvousRepository.save(existingRendezVous);

    }


    //delete rdv by ID
    @DeleteMapping("/{id}")
    public void deleteRendezVous(@PathVariable("id") Integer rdvid){

        rendezvousRepository.deleteById(rdvid);

    }

}
