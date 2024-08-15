package com.example.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.Login.Entity.Facture;
import com.example.Login.services.FactureService;
import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/factures")
public class FactureController {
	 @Autowired
	    private FactureService factureService;

	    @GetMapping("/client/{clientId}")
	    public List<Facture> getFacturesByClientId(@PathVariable Long clientId) {
	        return factureService.getFacturesByClientId(clientId);
	    }
	    
	    @GetMapping("/factures")
	    public List<Facture> getFacturesByDueDate(@RequestParam("dueDate") LocalDate dueDate) {
	        return factureService.getFacturesByDueDate(dueDate);
	    }
	 /*   
	    // Endpoint pour effectuer le paiement d'une facture
	    @PostMapping("/{factureId}/payer")
	    public ResponseEntity<?> payerFacture(@PathVariable Long factureId) {
	        try {
	            Facture facture = factureService.payerFacture(factureId);
	            return ResponseEntity.ok(facture);
	        } catch (NoSuchElementException e) {
	            return ResponseEntity.notFound().build();
	        } catch (IllegalStateException e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La facture a déjà été payée.");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }*/

}
