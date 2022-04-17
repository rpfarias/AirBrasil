package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.Ticket;
import com.airbrasil.apirest.repository.TicketRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/tickets")
@Api(value = "API REST Ticket", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {

    TicketRepository ticketRepository;
    private String destiny;
    private String origin;

    @ApiOperation(value="Retorna uma lista de Passagens")
    @GetMapping
    public List<Ticket> listTicket() {
        return ticketRepository.findAll();
    }

    @ApiOperation(value="Retorna uma passagem por destino")
    @GetMapping("/{destiny}")
    public List<Ticket> findByDestiny() {
        return ticketRepository.findByDestiny(destiny);
    }

    @ApiOperation(value="Retorna uma passagem por origem")
    @GetMapping("/{origin}")
    public List<Ticket> findByOrigin() {
        return ticketRepository.findByOrigin(origin);
    }

    @ApiOperation(value = "Cria uma Passagem")
    @PostMapping
    public Ticket createeTicket(@RequestBody @Valid Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @ApiOperation(value = "Altera uma Passagem")
    @PutMapping
    public Ticket updateTicket(@RequestBody @Valid Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
