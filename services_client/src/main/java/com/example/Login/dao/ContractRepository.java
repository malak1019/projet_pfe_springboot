package com.example.Login.dao;

import com.example.Login.Entity.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ContractRepository extends JpaRepository<Contrat, Long> {
	 Optional<Contrat> findByCodeContrat(Long codeContrat);
	 List<Contrat> findByStatut(String statut);
	 long count();
}
