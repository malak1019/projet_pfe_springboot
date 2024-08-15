package com.example.Login.controller;
import com.example.Login.dto.PaymentRequest;
import com.example.Login.Entity.Facture;
import com.example.Login.services.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/process")
    public ResponseEntity<?> processPayment(@RequestBody PaymentRequest paymentRequest) {
        try {
            Facture facture = paymentService.processPayment(paymentRequest);
            return ResponseEntity.ok(facture);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal server error: " + e.getMessage());
        } catch (StripeException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Payment processing error: " + e.getMessage());
        }
    }
}
