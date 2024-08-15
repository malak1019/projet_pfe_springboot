package com.example.Login.services;

import com.example.Login.dto.PaymentRequest;
import com.example.Login.Entity.Facture;
import com.example.Login.dao.FactureRepository;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentService.class);

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private StripeService stripeService;

    public Facture processPayment(PaymentRequest paymentRequest) throws StripeException {
        logger.info("Starting payment process for Facture ID: {}", paymentRequest.getFactureId());

        Facture facture = factureRepository.findById(paymentRequest.getFactureId())
                .orElseThrow(() -> new RuntimeException("Facture not found"));
        logger.info("Facture found: {}", facture);

        if (paymentRequest.getPaymentType().equalsIgnoreCase("CARD")) {
            logger.info("Processing card payment");
            Charge charge = stripeService.charge(paymentRequest.getToken(), paymentRequest.getAmount());
            if (charge.getStatus().equals("succeeded")) {
                logger.info("Card payment succeeded");
                facture.setStatus("PAID");
            } else {
                logger.error("Card payment failed with status: {}", charge.getStatus());
                throw new RuntimeException("Payment failed");
            }
        } else {
            logger.info("Processing non-card payment: {}", paymentRequest.getPaymentType());
            facture.setStatus("PAID");
        }

        facture.setPaymentType(paymentRequest.getPaymentType());
        logger.info("Setting payment type and updating Facture status to PAID");

        Facture savedFacture = factureRepository.save(facture);
        logger.info("Facture successfully updated: {}", savedFacture);
        return savedFacture;
    }
}
