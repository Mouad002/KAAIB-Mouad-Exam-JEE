package com.example.examenspring.dtos;

import com.example.examenspring.entities.Statut;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreditProfessionnelDTO extends CreditDTO{

    private String motif;
    private String raisonSociale;
}
