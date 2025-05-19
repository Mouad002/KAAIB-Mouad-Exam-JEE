package com.example.examenspring.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDemande;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    private Date dateIcceptation;
    private double montant;
    private int dureeRemboursement;
    private double tauxInteret;
    @ManyToOne()
    private Client client;
    @OneToMany(mappedBy = "credit")
    private List<Remboursement> remboursements;
}
