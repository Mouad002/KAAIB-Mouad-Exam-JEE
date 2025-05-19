package com.example.examenspring.web;

import com.example.examenspring.dtos.ClientDTO;
import com.example.examenspring.dtos.CreditDTO;
import com.example.examenspring.dtos.RemboursementDTO;
import com.example.examenspring.mappers.DtoMapper;
import com.example.examenspring.repositories.ClientRepository;
import com.example.examenspring.repositories.CreditRepository;
import com.example.examenspring.repositories.RemboursementRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/clients")
public class ClientController {

    private ClientRepository clientRepository;
    private CreditRepository creditRepository;
    private RemboursementRepository remboursementRepository;
    private DtoMapper dtoMapper;

    // GET /clients
    @GetMapping
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(DtoMapper::toClientDTO)
                .collect(Collectors.toList());
    }

    // GET /clients/{clientId}/credits
    @GetMapping("/{clientId}/credits")
    public List<CreditDTO> getCreditsByClient(@PathVariable Long clientId) {
        return creditRepository.findByClientId(clientId).stream()
                .map(DtoMapper::toCreditDTO)
                .collect(Collectors.toList());
    }

    // GET /credits/{creditId}/remboursements
    @GetMapping("/credits/{creditId}/remboursements")
    public List<RemboursementDTO> getRemboursementsByCredit(@PathVariable Long creditId) {
        return remboursementRepository.findByCreditId(creditId).stream()
                .map(DtoMapper::toRemboursementDTO)
                .collect(Collectors.toList());
    }
}
