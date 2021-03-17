package com.eddk.veterinaire_g10.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "prescription")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescriptionid;

    private String dateprescription;
    private String frequencedeprise;
    private int quantite;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "ordonnanceid"))
    private Ordonnance ordonnance;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "medicamentid"))
    private Medicament medicament;

    public Prescription() {
    }

    public int getPrescriptionId() {
        return prescriptionid;
    }

    public void setPrescriptionId(int prescriptionid) {
        this.prescriptionid = prescriptionid;
    }

    public String getDatePrescription() {
        return dateprescription;
    }

    public void setDatePrescription(String date_prescription) {
        this.dateprescription = date_prescription;
    }

    public String getFrequenceDePrise() {
        return frequencedeprise;
    }

    public void setFrequenceDePrise(String frequencedeprise) {
        this.frequencedeprise = frequencedeprise;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }
}
