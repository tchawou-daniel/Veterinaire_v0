package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "rendezvous")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rdvid;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "animalid"))
    private Animal animal;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "medecinid"))
    private Medecin medecin;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="rendezvous")
    @JsonIgnore
    private List<Ordonnance> ordonnances;

    private Date daterdv;
    private Date heuredebutrdv;
    private Date heurefinrdv;

    public RendezVous() {
    }

    public RendezVous(Animal animal, Medecin medecin, List<Ordonnance> ordonnances, Date daterdv, Date heuredebutrdv, Date heurefinrdv) {
        this.animal = animal;
        this.medecin = medecin;
        this.ordonnances = ordonnances;
        this.daterdv = daterdv;
        this.heuredebutrdv = heuredebutrdv;
        this.heurefinrdv = heurefinrdv;
    }

    public int getRdvId() {
        return rdvid;
    }

    public void setRdvId(int rdv_id) {
        this.rdvid = rdvid;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public List<Ordonnance> getOrdonnances() {
        return ordonnances;
    }

    public void setOrdonnances(List<Ordonnance> ordonnances) {
        this.ordonnances = ordonnances;
    }

    public Date getDateRdv() {
        return daterdv;
    }

    public void setDateRdv(Date daterdv) {
        this.daterdv = daterdv;
    }

    public Date getHeureDebutRdv() {
        return heuredebutrdv;
    }

    public void setHeureDebutRdv(Date heuredebutrdv) {
        this.heuredebutrdv = heuredebutrdv;
    }

    public Date getHeureFinRdv() {
        return heurefinrdv;
    }

    public void setHeureFinRdv(Date heurefinrdv) {
        this.heurefinrdv = heurefinrdv;
    }

}
