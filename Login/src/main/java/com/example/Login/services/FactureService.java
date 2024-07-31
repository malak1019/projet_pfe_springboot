package com.example.Login.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Login.Entity.Facture;
import com.example.Login.dao.FactureRepository;

import java.time.LocalDate;
import java.util.List;


@Service
public class FactureService {
	 @Autowired
	    private FactureRepository factureRepository;

	    public List<Facture> getFacturesByClientId(Long clientId) {
	        return factureRepository.findByClientId(clientId);
	    }
	    
	    public List<Facture> getFacturesByDueDate(LocalDate dueDate) {
	        return factureRepository.findByDueDate(dueDate);
	    }
	    
	    
}
