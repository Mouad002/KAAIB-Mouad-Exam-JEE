package com.example.examenspring.dtos;

import com.example.examenspring.entities.Statut;
import com.example.examenspring.entities.TypeBien;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreditImmobilierDTO extends CreditDTO{
    private TypeBien typeBien;

    // Getters and Setters
}

