package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "medicament")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicamentid;

    public String nommedicament;

    public String description;

    @OneToMany(mappedBy="medicament")
    @JsonIgnore
    private List<Prescription> prescriptions;


    public Medicament() {
    }

}
