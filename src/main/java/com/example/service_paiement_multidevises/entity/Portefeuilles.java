package com.example.service_paiement_multidevises.entity;

import com.example.service_paiement_multidevises.dto.Devise;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "portefeuilles")
public class Portefeuilles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Devise devise;

    @OneToMany(mappedBy = "destinateur", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Transaction> Transactions_sortantes;

    @OneToMany(mappedBy = "destinataire", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Transaction> Transactions_entrantes;

    @ElementCollection
    @CollectionTable(name = "portefeuille_expenses", joinColumns = @JoinColumn(name = "portefeuille_id"))
    @Column(name = "expense_id")
    private List<Long> expensIds;

}
