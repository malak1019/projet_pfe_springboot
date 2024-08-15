package com.example.Login.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.Login.Entity.*;
import com.example.Login.dao.ContractRepository;
import com.example.Login.dao.ClientRepository;

import com.example.Login.dto.ContratDTO;


@Service
public class ContractService {

	 @Autowired
	    private ContractRepository contratRepository;

	    @Autowired
	    private ClientRepository clientRepository;    

    @Autowired
    public ContractService(ContractRepository contratRepository) {
        this.contratRepository = contratRepository;
    }
    
    public long getContratCount() {
		return contratRepository.count();
	}
    
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }
    
    public List<Contrat> getContratsByStatus(String statut) {
        return contratRepository.findByStatut(statut);
    }

    public Contrat createContrat(ContratDTO contratDTO) {
        Client client = clientRepository.findById(contratDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Contrat contrat = new Contrat();
        contrat.setCodeContrat(contratDTO.getCodeContrat());
        contrat.setDateActivation(contratDTO.getDateActivation()); // Conversion de String à Date
        contrat.setStatut(contratDTO.getStatut());
        contrat.setNumAppel(contratDTO.getNumAppel());
        contrat.setClient(client);

        return contratRepository.save(contrat);
    }
    
    public boolean deleteContrat(Long codeContrat) {
        Optional<Contrat> contratOptional = contratRepository.findById(codeContrat);
        if (contratOptional.isPresent()) {
            contratRepository.delete(contratOptional.get());
            return true;
        }
        return false;
    }
    
    public Contrat updateContrat(Long codeContrat, Contrat contratDetails) {
        Optional<Contrat> existingContratOptional = contratRepository.findById(codeContrat);
        if (existingContratOptional.isPresent()) {
            Contrat existingContrat = existingContratOptional.get();
            // Mettre à jour les champs nécessaires du contrat existant
            existingContrat.setDateActivation(contratDetails.getDateActivation());
            existingContrat.setStatut(contratDetails.getStatut());
            existingContrat.setNumAppel(contratDetails.getNumAppel());
            existingContrat.setClient(contratDetails.getClient());
            existingContrat.setPromotions(contratDetails.getPromotions());

            // Enregistrer et retourner le contrat mis à jour
            return contratRepository.save(existingContrat);
        }
        return null;
    }
    
    public Contrat archiveContrat(Long id) {
        Contrat contrat = contratRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrat non trouvé"));
        contrat.setArchived(true);
        return contratRepository.save(contrat);
    }
    
}