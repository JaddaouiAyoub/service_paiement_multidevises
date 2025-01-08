package com.example.service_paiement_multidevises.controller;

import com.example.service_paiement_multidevises.dto.PortefeuillesDTO;
import com.example.service_paiement_multidevises.dto.TransactionDTO;
import com.example.service_paiement_multidevises.service.MultiDevisesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final MultiDevisesService paymentService;

    public PaymentController(MultiDevisesService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/{senderWalletId}/{receiverWalletId}/{amount}")
    public TransactionDTO makePayment(@PathVariable Long senderWalletId,
                                      @PathVariable Long receiverWalletId,
                                      @PathVariable Double amount) {
        return paymentService.processPayment(senderWalletId, receiverWalletId, amount);
    }

    @GetMapping("/{id}/balance")
    public ResponseEntity<Double> getBalance(@PathVariable Long id) {
        Double balance = paymentService.getMontant(id);
        if (balance != null) {
            return ResponseEntity.ok(balance);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/portefeuille")
    public ResponseEntity<PortefeuillesDTO> getPortefeuille(@PathVariable Long id) {

        PortefeuillesDTO portefeuilles = paymentService.getPortefeuilles(id);
        if (portefeuilles!= null) {
            return ResponseEntity.ok(portefeuilles);
        } else {
            return ResponseEntity.notFound().build();
        }

    }








}


