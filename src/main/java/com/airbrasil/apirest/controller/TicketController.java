package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.Ticket;
import com.airbrasil.apirest.repository.TicketRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
public class TicketController {

    TicketRepository ticketRepository;
    private String destiny;
    private String origin;

    @ApiOperation(value="Retorna uma lista de Passagens")
    @GetMapping("/tickets")
    public List<Ticket> listTicket() {
        return ticketRepository.findAll();
    }

    @ApiOperation(value="Retorna uma passagem por destino")
    @GetMapping("/ticket/{destiny}")
    public Optional<Ticket> findByDestiny() {
        return ticketRepository.findByDestino(destiny);
    }

    @ApiOperation(value="Retorna uma passagem por origem")
    @GetMapping("/ticket/{origin}")
    public Optional<Ticket> findByOrigin() {
        return ticketRepository.findByOrigem(origin);
    }
}
