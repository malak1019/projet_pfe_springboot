/*package com.example.Login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.Login.Entity.Facture;
import com.example.Login.Entity.Client;
import com.example.Login.dao.FactureRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceScheduler {

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private SmsService smsService;

    @Scheduled(cron = "0 0 9 * * ?") // Tous les jours à 9h00
    public void checkAndSendSms() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        List<Facture> factures = factureRepository.findByDueDate(tomorrow);

        for (Facture facture : factures) {
            Client client = facture.getClient();
            String toPhoneNumber = client.getNumTel();
            String message = "Hello World";
            smsService.sendSms(toPhoneNumber, message);
        }
    }
}
*/
