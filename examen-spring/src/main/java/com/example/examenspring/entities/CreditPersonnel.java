package com.example.examenspring.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("per")
@Data
@NoArgsConstructor
@AllArgsConstructor
class CreditPersonnel extends Credit {
    private String motif;
}
