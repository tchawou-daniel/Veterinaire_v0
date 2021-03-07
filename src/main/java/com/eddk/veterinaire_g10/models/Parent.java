package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
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

    @OneToMany(mappedBy="parent")
    @JsonIgnore
    private List<Animal> animals;

    public Parent(int parentid,String nomparent,String prenomparent){
        this.parentid = parentid;
        this.nomparent = nomparent;
        this.prenomparent = prenomparent;
    }
    public Parent() {
    }
    public String getNomParent() {
        return nomparent;
    }
    public void setNomParent(String nomparent) {
        this.nomparent=nomparent;
    }

    public String getPrenomParent() {
        return prenomparent;
    }
    public void setPrenomParent(String prenomparent) {
        this.prenomparent=prenomparent;
    }

}
