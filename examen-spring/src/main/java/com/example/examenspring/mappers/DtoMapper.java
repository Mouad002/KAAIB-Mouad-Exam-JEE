package com.example.examenspring.mappers;

import com.example.examenspring.dtos.*;
import com.example.examenspring.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class DtoMapper {

    // --- Client ---
    public static ClientDTO toClientDTO(Client client) {
        if (client == null) return null;
        ClientDTO dto = new ClientDTO();
        BeanUtils.copyProperties(client, dto);
        return dto;
    }

    public static Client toClient(ClientDTO dto) {
        if (dto == null) return null;
        Client client = new Client();
        BeanUtils.copyProperties(dto, client);
        return client;
    }

    // --- CreditPersonnel ---
    public static CreditPersonnelDTO toCreditPersonnelDTO(CreditPersonnel credit) {
        if (credit == null) return null;
        CreditPersonnelDTO dto = new CreditPersonnelDTO();
        BeanUtils.copyProperties(credit, dto);
        return dto;
    }

    public static CreditPersonnel toCreditPersonnel(CreditPersonnelDTO dto) {
        if (dto == null) return null;
        CreditPersonnel credit = new CreditPersonnel();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    // --- CreditProfessionnel ---
    public static CreditProfessionnelDTO toCreditProfessionnelDTO(CreditProfessionnel credit) {
        if (credit == null) return null;
        CreditProfessionnelDTO dto = new CreditProfessionnelDTO();
        BeanUtils.copyProperties(credit, dto);
        return dto;
    }

    public static CreditProfessionnel toCreditProfessionnel(CreditProfessionnelDTO dto) {
        if (dto == null) return null;
        CreditProfessionnel credit = new CreditProfessionnel();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    // --- CreditImmobilier ---
    public static CreditImmobilierDTO toCreditImmobilierDTO(CreditImmobilier credit) {
        if (credit == null) return null;
        CreditImmobilierDTO dto = new CreditImmobilierDTO();
        BeanUtils.copyProperties(credit, dto);
        return dto;
    }

    public static CreditImmobilier toCreditImmobilier(CreditImmobilierDTO dto) {
        if (dto == null) return null;
        CreditImmobilier credit = new CreditImmobilier();
        BeanUtils.copyProperties(dto, credit);
        return credit;
    }

    // --- Remboursement ---
    public static RemboursementDTO toRemboursementDTO(Remboursement r) {
        if (r == null) return null;
        RemboursementDTO dto = new RemboursementDTO();
        BeanUtils.copyProperties(r, dto);
        return dto;
    }

    public static Remboursement toRemboursement(RemboursementDTO dto) {
        if (dto == null) return null;
        Remboursement r = new Remboursement();
        BeanUtils.copyProperties(dto, r);
        return r;
    }

    public static CreditDTO toCreditDTO(Credit credit) {
        if (credit == null) return null;

        if (credit instanceof CreditPersonnel) {
            return toCreditPersonnelDTO((CreditPersonnel) credit);
        } else if (credit instanceof CreditProfessionnel) {
            return toCreditProfessionnelDTO((CreditProfessionnel) credit);
        } else if (credit instanceof CreditImmobilier) {
            return toCreditImmobilierDTO((CreditImmobilier) credit);
        } else {
            // Fallback to generic base class mapping
            CreditDTO dto = new CreditDTO();
            BeanUtils.copyProperties(credit, dto);
            return dto;
        }
    }

}
