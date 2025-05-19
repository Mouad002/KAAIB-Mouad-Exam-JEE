package com.example.examenspring.entities;

import java.util.Date;
import java.util.List;


class Credit {
    private int id;
    private Date date_demande;
    private Statut statut;
    private Date date_acceptation;
    private double montant;
    private int duree_remboursement;
    private double taux_interet;
    private Client client;
    private List<Remboursement> remboursements;
}
