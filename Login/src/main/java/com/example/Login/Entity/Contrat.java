package com.example.Login.Entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_contrat")
    private Long codeContrat;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateActivation; // camelCase

    private String statut;

    private String numAppel; // camelCase

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    @ManyToMany
    @JoinTable(
        name = "contrat_promotion",
        joinColumns = @JoinColumn(name = "code_contrat"),
        inverseJoinColumns = @JoinColumn(name = "promotion_id")
    )
    @JsonIgnore
    private List<Promotion> promotions = new ArrayList<>();

    // Getters et setters

    public Long getCodeContrat() {
        return codeContrat;
    }

    public void setCodeContrat(Long string) {
        this.codeContrat = string;
    }

    public Date getDateActivation() {
        return dateActivation;
    }

    public void setDateActivation(Date dateActivation) {
        this.dateActivation = dateActivation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getNumAppel() {
        return numAppel;
    }

    public void setNumAppel(String numAppel) {
        this.numAppel = numAppel;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }
}
