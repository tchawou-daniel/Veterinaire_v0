package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "ordonnance")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Ordonnance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordonnanceid;

    private String nomordonnance;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "rdvid"))
    private RendezVous rendezvous;

    @OneToMany(mappedBy = "ordonnance")
    @JsonIgnore
    private List<Prescription> prescriptions;

    public Ordonnance(RendezVous rendezvous, List<Prescription> prescriptions) {
        this.rendezvous = rendezvous;
        this.prescriptions = prescriptions;
    }

    public Ordonnance() {
    }

    public int getOrdonnanceId() {
        return ordonnanceid;
    }

    public void setOrdonnanceId(int ordonnanceid) {
        this.ordonnanceid = ordonnanceid;
    }

    public RendezVous getRendezVous() {
        return rendezvous;
    }

    public void setRendezVous(RendezVous rendezvous) {
        this.rendezvous = rendezvous;
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(List<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    public Ordonnance(RendezVous rendezvous) {
        this.rendezvous = rendezvous;
    }
}
