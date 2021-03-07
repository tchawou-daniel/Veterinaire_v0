package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "typeanimal")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TypeAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeanimalid;

    private String libtypeanimal;

    @OneToMany(mappedBy="typeanimal")
    @JsonIgnore
    private List<Animal> animals;

    public TypeAnimal() {
    }

    public String getLibTypeAnimal() {
        return libtypeanimal;
    }

    public void setLibTypeAnimal(String libtypeanimal) {
        this.libtypeanimal = libtypeanimal;
    }
}
