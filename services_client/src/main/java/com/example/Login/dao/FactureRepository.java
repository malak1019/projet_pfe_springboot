package com.example.Login.dao;
import com.example.Login.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FactureRepository  extends JpaRepository<Facture, Long> {
	List<Facture> findByClientId(Long clientId);

	 List<Facture> findByDueDate(LocalDate dueDate);
}
