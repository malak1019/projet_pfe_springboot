package com.example.Login.dto;

import java.util.Date;

public class ContratDTO {
    private Long codeContrat;
    private Date dateActivation; // camelCase
    private String statut;
    private String numAppel; // camelCase
    private Long clientId;

    // Getters et setters

    public Long getCodeContrat() {
        return codeContrat;
    }

    public void setCodeContrat(Long codeContrat) {
        this.codeContrat = codeContrat;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
