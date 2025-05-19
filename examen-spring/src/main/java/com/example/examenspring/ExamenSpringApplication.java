package com.example.examenspring;

import com.example.examenspring.entities.*;
import com.example.examenspring.repositories.ClientRepository;
import com.example.examenspring.repositories.CreditRepository;
import com.example.examenspring.repositories.RemboursementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ExamenSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamenSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository, CreditRepository creditRepository, RemboursementRepository remboursementRepository) {
        return args -> {
            List<Client> clients = new ArrayList<>();

            // Create 3 clients
            for (int i = 1; i <= 3; i++) {
                Client client = new Client();
                client.setNom("Client " + i);
                client.setEmail("client" + i + "@example.com");
                client.setCredits(new ArrayList<>());
                clients.add(client);
            }

            List<Credit> allCredits = new ArrayList<>();
            List<Remboursement> allRemboursements = new ArrayList<>();

            Random rand = new Random();
            int creditCount = 0;

            for (Client client : clients) {
                int clientCredits = 0;

                while (clientCredits < 3 && creditCount < 10) {
                    Credit credit;

                    switch (creditCount % 3) {
                        case 0:
                            CreditPersonnel cp = new CreditPersonnel();
                            cp.setMotif("Travaux maison");
                            credit = cp;
                            break;
                        case 1:
                            CreditImmobilier ci = new CreditImmobilier();
                            ci.setTypeBien(TypeBien.APPARTEMENT);
                            credit = ci;
                            break;
                        default:
                            CreditProfessionnel crp = new CreditProfessionnel();
                            crp.setMotif("Achat matériel");
                            crp.setRaisonSociale("Entreprise SARL");
                            credit = crp;
                            break;
                    }

                    credit.setClient(client);
                    credit.setDateDemande(LocalDate.now().minusDays(rand.nextInt(100)));
                    credit.setStatut(Statut.values()[rand.nextInt(3)]);
                    credit.setMontant(10000 + rand.nextInt(50000));
                    credit.setTauxInteret(4 + rand.nextDouble() * 3);
                    credit.setDureeRemboursement(12 + rand.nextInt(24));
                    credit.setDateAcceptation(LocalDate.now().minusDays(rand.nextInt(90)));

                    credit.setRemboursements(new ArrayList<>());
                    client.getCredits().add(credit);
                    allCredits.add(credit);
                    creditCount++;
                    clientCredits++;
                }
            }

            // 20 Remboursements distributed across credits
            int remboursementCount = 0;
            while (remboursementCount < 20) {
                Credit credit = allCredits.get(rand.nextInt(allCredits.size()));
                Remboursement r = new Remboursement();
                r.setCredit(credit);
                r.setDate(LocalDate.now().minusDays(rand.nextInt(180)));
                r.setMontant(500 + rand.nextInt(1000));
                r.setType(TypeRemboursement.values()[rand.nextInt(2)]);

                credit.getRemboursements().add(r);
                allRemboursements.add(r);
                remboursementCount++;
            }

            // Save all clients (cascade saves credits and remboursements)
            clientRepository.saveAll(clients);

            System.out.println("Sample data inserted: 3 clients, 10 credits, 20 remboursements.");
        };
    }

}
