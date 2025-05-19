package com.example.examenspring.dtos;

import com.example.examenspring.entities.Statut;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreditDTO {
    private Long id;
    private LocalDate dateDemande;
    private Statut statut;
    private LocalDate dateAcceptation;
    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;
}
