package com.example.Login.services;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.example.Login.Entity.Facture;
import com.example.Login.dao.FactureRepository;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class SchedulerService {
	
		private static final Logger logger = LoggerFactory.getLogger(SchedulerService.class);
	
	 	@Autowired
	    private FactureRepository factureRepository;

	    @Autowired
	    private SmsService smsService;

	    //@Scheduled(cron = "0 * * * * *") // Runs every minute
	    //@Scheduled(cron = "0 */5 * * * *") //Runs every 5 minute
	    @Scheduled(cron = "0 0 10 * * *") // Runs every day at 10 AM
	    public void sendPaymentReminders() {
	        LocalDate tomorrow = LocalDate.now().plusDays(1);
	        List<Facture> dueFactures = factureRepository.findByDueDate(tomorrow);
	        logger.info("Found {} factures due tomorrow", dueFactures.size());

	        for (Facture facture : dueFactures) {
	            String message = String.format("Cher client, Orange vous informe que la date limite de payement de votre facture est demain, Pour evité la suppresion de votre ligne veillez procéder au paiement de %.2f Dt.", facture.getMontant());
	            logger.info("Sending SMS to {} with message: {}", facture.getClient().getNumTel(), message);
	            smsService.sendSms(facture.getClient().getNumTel(), message);
	        }
	    }
	    }
