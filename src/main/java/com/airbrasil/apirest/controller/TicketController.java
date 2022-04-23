package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.Ticket;
import com.airbrasil.apirest.domain.request.CreateTicketRequest;
import com.airbrasil.apirest.domain.request.UpdateTicketRequest;
import com.airbrasil.apirest.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api/tickets")
@Api(value = "API REST Ticket", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TicketController {

    @Autowired
    private final TicketService ticketService;

    private String destiny;
    private String origin;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @ApiOperation(value="Retorna uma lista de Passagens")
    @GetMapping
    public List<Ticket> listTicket() {
        return ticketService.findAll();
    }

    @ApiOperation(value="Retorna uma lista de passagens por destino")
    @GetMapping("/destiny/{destiny}")
    public List<Ticket> findAllByDestiny(@PathVariable String destiny) {
        return ticketService.findByDestiny(destiny);
    }

    @ApiOperation(value="Retorna uma lista de passagens por origem")
    @GetMapping("/origin/{origin}")
    public List<Ticket> findAllByOrigin(@PathVariable String origin) {
        return ticketService.findByOrigin(origin);
    }

    @ApiOperation(value="Retorna passagens por nome no Passageiro")
    @GetMapping("/passager/{passager}")
    public List<Ticket> findAllByPassager(@PathVariable String passager) {
        return ticketService.findAllByPassager(passager);
    }

    @ApiOperation(value = "Cria uma Passagem")
    @PostMapping
    public Ticket create(@RequestBody @Valid CreateTicketRequest ticket) {
        return ticketService.create(ticket);
    }

    @ApiOperation(value = "Altera uma Passagem")
    @PutMapping
    public Ticket update(@RequestBody @Valid Ticket ticket) {
        return ticketService.update(ticket);
    }

    @ApiOperation(value = "Deleta uma Passagem por Id")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ("id") Long id) {
        ticketService.deleteById(id);
    }
}
