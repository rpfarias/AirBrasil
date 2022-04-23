package com.airbrasil.apirest.service;

import com.airbrasil.apirest.domain.model.Ticket;
import com.airbrasil.apirest.domain.request.CreateTicketRequest;
import com.airbrasil.apirest.domain.request.UpdateTicketRequest;
import com.airbrasil.apirest.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    public List<Ticket> findByDestiny(@PathVariable String destiny) {
        return ticketRepository.findByDestiny(destiny);
    }

    public List<Ticket> findByOrigin(@PathVariable String origin) {
        return ticketRepository.findByOrigin(origin);
    }

    public List<Ticket> findAllByPassager(@PathVariable String passager) {
        return ticketRepository.findByPassager(passager);
    }

    public Ticket create(@RequestBody @Valid CreateTicketRequest request) {

        Ticket ticket = new Ticket();
        ticket.setPassager(request.getPassager());
        ticket.setOrigin(request.getOrigin());
        ticket.setDestiny(request.getDestiny());
        ticket.setPrice(request.getPrice());
        ticket.setDataIda(request.getDataIda());
        ticket.setDataVolta(request.getDataVolta());
        ticket.setUserId(request.getUserId());
        return ticketRepository.save(ticket);
    }

    public Ticket update(@RequestBody @Valid Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void deleteById(@PathVariable ("id") Long id) {
        ticketRepository.deleteById(id);
    }
}
