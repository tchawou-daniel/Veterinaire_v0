package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "animal")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalid;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "parentid"))
    private Parent parent;

    private String nomanimal;
    private String sexanimal;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "animal")
    private List<RendezVous> rendezvous;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "typeanimalid"))
    private TypeAnimal typeanimal;

    public Animal(int animalid, String nomanimal, String sexanimal, TypeAnimal typeanimal) {
        this.animalid = animalid;
        this.nomanimal = sexanimal;
        this.sexanimal = sexanimal;
        this.typeanimal = typeanimal;
    }

    public Animal() {
    }

}
