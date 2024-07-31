package com.example.Login.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.Login.Entity.Contrat;
import com.example.Login.dto.ContratDTO;
import com.example.Login.services.ContractService;

@RestController
@RequestMapping("/api/contrats")
@CrossOrigin(origins = "http://localhost:4200")
public class ContratController {

    private final ContractService contratService;

    @Autowired
    public ContratController(ContractService contratService) {
        this.contratService = contratService;
    }

    @PostMapping("/create")
    public Contrat createContrat(@RequestBody ContratDTO contratDTO) {
        return contratService.createContrat(contratDTO);
    }

    @DeleteMapping("/delete/{codeContrat}")
    public ResponseEntity<String> deleteContrat(@PathVariable Long codeContrat) {
        boolean deleted = contratService.deleteContrat(codeContrat);
        if (deleted) {
            return ResponseEntity.ok("Contrat supprimé avec succès");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contrat non trouvé");
        }
    }

    @PutMapping("/updateC/{codeContrat}")
    public ResponseEntity<Contrat> updateContrat(@PathVariable Long codeContrat, @RequestBody Contrat contratDetails) {
        Contrat updatedContrat = contratService.updateContrat(codeContrat, contratDetails);
        if (updatedContrat != null) {
            return ResponseEntity.ok(updatedContrat);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
