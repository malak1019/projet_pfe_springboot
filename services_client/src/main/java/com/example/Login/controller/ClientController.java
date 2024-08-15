package com.example.Login.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Login.Entity.Client;
import com.example.Login.Entity.Contrat;
import com.example.Login.Entity.Promotion;
import com.example.Login.dao.ClientRepository;
import com.example.Login.services.ClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/clients")

public class ClientController {

    @Autowired
    private ClientService clientService;

    private ClientRepository clientRepository;
    
    @GetMapping("/count")
    public long getClientCount() {
        return clientService.getClientCount();
    }

    // la méthode qui permet de rechercher un client par son id
    @GetMapping("/recherche/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Optional<Client> client = clientService.findClientById(id);
        return client.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint pour rechercher un contrat par codeContrat
    @GetMapping("/contrats/rech/{codeContrat}")
    public ResponseEntity<Contrat> getContratByCodeContrat(@PathVariable Long codeContrat) {
        try {
            Optional<Contrat> contrat = clientService.findByCodeContrat(codeContrat);
            return contrat.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            // Logguer l'exception pour le débogage
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/contrats/{clientId}")
    public ResponseEntity<List<Contrat>> getContratsClient(@PathVariable Long clientId) {
        try {
            List<Contrat> contrats = clientService.findContratsByClientId(clientId);
            if (!contrats.isEmpty()) {
                return ResponseEntity.ok(contrats);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
        } catch (Exception e) {
            // Logger l'exception pour le débogage
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // méthode pour rechercher les promotions associées à un contrat par codeContrat
    @GetMapping("/contrats/{codeContrat}/promotions")
    public ResponseEntity<List<Promotion>> getPromotionsByContratCode(@PathVariable Long codeContrat) {
        List<Promotion> promotions = clientService.findPromotionsByContratCode(codeContrat);
        if (promotions.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(promotions);
        }
    }

    // la methode qui permet de modifier les information d'un client
    @PatchMapping("/update/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable Long clientId, @RequestBody Map<String, Object> updates) {
        Client updatedClient = clientService.updateClient(clientId, updates);
        if (updatedClient != null) {
            return ResponseEntity.ok(updatedClient);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Endpoint pour créer un nouveau client

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        Client createdClient = clientService.createClient(client);
        return new ResponseEntity<>(createdClient, HttpStatus.CREATED);
    }

    /// nbre clients
    @GetMapping("/clients")
    public Long getMethodName() {
        Long nbre = clientService.NombreClient();
        return nbre;
    }

}
