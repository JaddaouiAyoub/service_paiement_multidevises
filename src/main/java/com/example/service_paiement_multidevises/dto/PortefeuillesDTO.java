package com.example.service_paiement_multidevises.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortefeuillesDTO {
    private Long id;
    private Long utilisateurId;
    private Double balance;
    private Devise devise; // USD, MAD, EUR
//    private List<TransactionDTO> transactions_sortantes;
//    private List<TransactionDTO> transactions_entrantes;
}
