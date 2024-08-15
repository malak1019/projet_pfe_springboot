package com.example.Login.dto;

public class PaymentRequest {
	 private Long factureId;
	    private String token; // for card payments
	    private double amount;
	    private String paymentType; // CASH, CHECK, CARD

	    // Getters and Setters

	    public Long getFactureId() {
	        return factureId;
	    }

	    public void setFactureId(Long factureId) {
	        this.factureId = factureId;
	    }

	    public String getToken() {
	        return token;
	    }

	    public void setToken(String token) {
	        this.token = token;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }

	    public String getPaymentType() {
	        return paymentType;
	    }

	    public void setPaymentType(String paymentType) {
	        this.paymentType = paymentType;
	    }
	}


