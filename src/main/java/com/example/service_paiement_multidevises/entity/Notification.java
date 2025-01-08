package com.example.service_paiement_multidevises.entity;

import com.example.service_paiement_multidevises.dto.NotificationType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private NotificationType type; // EMAIL, SMS, PUSH

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();
}

