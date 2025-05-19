package com.example.examenspring.dtos;

import com.example.examenspring.entities.TypeRemboursement;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RemboursementDTO {
    private Long id;
    private LocalDate date;
    private double montant;
    private TypeRemboursement type;

    // Getters and Setters
}