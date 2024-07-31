package com.example.Login.Entity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   
    private String name_promo;
    private String description;
    private String date_affectation;
    private String date_suppression;

    @ManyToMany(mappedBy = "promotions")
    private List<Contrat> contrats = new ArrayList<>();

    // Getters et setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_promo() {
        return name_promo;
    }

    public void setName_promo(String name_promo) {
        this.name_promo = name_promo;
    }

    public String getDate_affectation() {
        return date_affectation;
    }

    public void setDate_affectation(String date_affectation) {
        this.date_affectation = date_affectation;
    }

    public String getDate_suppression() {
        return date_suppression;
    }

    public void setDate_suppression(String date_suppression) {
        this.date_suppression = date_suppression;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }
}
