package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "parent")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parentid;
    private String nomparent;
    private String prenomparent;
    private String typeparent;

    private enum TYPEPARENT {HOMME, FEMME}

    @OneToMany(mappedBy = "parent")
    @JsonIgnore
    @Size(min = 1, max = 2)
    private List<Animal> animals;


    public Parent(int parentid, String nomparent, String prenomparent, String typeparent) {
        this.parentid = parentid;
        this.nomparent = nomparent;
        this.prenomparent = prenomparent;
        this.typeparent = typeparent;
    }

    public Parent() {
    }
    public String getTypeparent(){
        return typeparent;
    }


}
