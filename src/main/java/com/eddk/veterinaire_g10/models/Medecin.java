package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;

@EntityScan
@Entity(name = "medecin")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medecinid;
    private String nommedecin;
    private String prenommedecin;
    private String contact;

    @OneToMany(mappedBy="medecin")
    @JsonIgnore
    private List<RendezVous> rendezvous;

    public Medecin() {
    }

    public String getNomMedecin() {
        return nommedecin;
    }

    public void setNomMedecin(String nommedecin) {
        this.nommedecin = nommedecin;
    }

    public String getPrenomMedecin() {
        return prenommedecin;
    }

    public void setPrenomMedecin(String prenommedecin) {
        this.prenommedecin = prenommedecin;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
