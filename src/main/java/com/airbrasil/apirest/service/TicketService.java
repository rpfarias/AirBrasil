package com.airbrasil.apirest.service;

import com.airbrasil.apirest.domain.model.Ticket;
import com.airbrasil.apirest.domain.request.TicketRequest;
import com.airbrasil.apirest.enums.StatusVoo;
import com.airbrasil.apirest.repository.StatusRepository;
import com.airbrasil.apirest.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final StatusRepository statusRepository;

    public TicketService(TicketRepository ticketRepository, StatusRepository statusRepository) {
        this.ticketRepository = ticketRepository;
        this.statusRepository = statusRepository;
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

    public Ticket create(@RequestBody @Valid TicketRequest request) {

        Ticket ticket = new Ticket();
        ticket.setOrigin(request.getOrigin());
        ticket.setDestiny(request.getDestiny());
        ticket.setPassager(request.getPassager());
        ticket.setDataIda(request.getDataIda());
        ticket.setDataVolta(request.getDataVolta());
        var status = statusRepository.findByStatus(StatusVoo.AGUARDANDO_STATUS_DO_VOO);
        status.ifPresent(value -> ticket.getStatusVoo().add(value));

        return ticketRepository.save(ticket);
    }

    public Ticket update(@RequestBody @Valid Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void deleteById(@PathVariable Long id) {
        ticketRepository.deleteById(id);
    }
}
