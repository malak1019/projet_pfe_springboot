package com.example.Login.services;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Login.Entity.Client;
import com.example.Login.Entity.Contrat;
import com.example.Login.Entity.Promotion;
import com.example.Login.dao.ClientRepository;
import com.example.Login.dao.ContractRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ContractRepository contratRepo;

    public Optional<Client> findClientById(Long id) {
        return clientRepository.findById(id);
    }
    
   

    /*
     * public List<Contrat> findContractsByClientId(Long clientId) {
     * Optional<Client> client = clientRepository.findById(clientId);
     * return client.map(Client::getContrats).orElse(Collections.emptyList());
     * }
     */

    // Recherche de contrat par codeContrat
    public Optional<Contrat> findByCodeContrat(Long codeContrat) {
        return contratRepo.findByCodeContrat(codeContrat);
    }

    public List<Contrat> findContratsByClientId(Long clientId) {
        // Implémentez la logique pour récupérer les contrats d'un client spécifique
        return clientRepository.findById(clientId)
                .map(Client::getContrats)
                .orElse(Collections.emptyList());
    }

    // Recherche des promotions associées à un contrat par codeContrat
    public List<Promotion> findPromotionsByContratCode(Long codeContrat) {
        Optional<Contrat> contrat = contratRepo.findByCodeContrat(codeContrat);
        return contrat.map(Contrat::getPromotions).orElse(Collections.emptyList());
    }

    public Client updateClient(Long clientId, Map<String, Object> updates) {
        Optional<Client> optionalClient = clientRepository.findById(clientId);
        if (!optionalClient.isPresent()) {
            return null;
        }

        Client client = optionalClient.get();

        // Appliquer les mises à jour partielles
        updates.forEach((key, value) -> {
            switch (key) {
                case "firstName":
                    client.setFirstName((String) value);
                    break;
                case "lastName":
                    client.setLastName((String) value);
                    break;
                case "numTel":
                    client.setNumTel((String) value);
                    break;
                case "cin":
                    client.setCin((String) value);
                    break;
                case "adresse":
                    client.setAdresse((String) value);
                    break;
                // Ajoutez d'autres cas pour chaque champ que vous souhaitez mettre à jour
            }
        });

        return clientRepository.save(client);
    }

    // Méthode pour créer un nouveau client
    public Client createClient(Client client) {
        // Logique de validation ou de traitement métier avant d'enregistrer en base de
        // données
        return clientRepository.save(client);
    }

    /// get all client
    public long NombreClient() {
        return clientRepository.count();
    }

	public long getClientCount() {
		// TODO Auto-generated method stub
		return clientRepository.count();
	}

}
