package com.airbrasil.apirest.service;

import com.airbrasil.apirest.domain.model.Ticket;
import com.airbrasil.apirest.domain.request.TicketRequest;
import com.airbrasil.apirest.domain.request.TicketUpdateRequest;
import com.airbrasil.apirest.repository.TicketRepository;
import org.springframework.stereotype.Service;

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

    public List<Ticket> ticketByCpf( String cpf) { return ticketRepository.findByCpf(cpf); }

    public List<Ticket> findByDestiny( String destiny) {
        return ticketRepository.findByDestiny(destiny);
    }

    public List<Ticket> findByOrigin( String origin) {
        return ticketRepository.findByOrigin(origin);
    }

    public List<Ticket> findAllByPassager( String passager) {
        return ticketRepository.findByPassager(passager);
    }

    public Ticket create( TicketRequest createRequest) {

        Ticket ticket = new Ticket();
        ticket.setPassager(createRequest.getPassager());
        ticket.setCpf(createRequest.getCpf());
        ticket.setOrigin(createRequest.getOrigin());
        ticket.setDestiny(createRequest.getDestiny());
        ticket.setPrice(createRequest.getPrice());
        ticket.setDataIda(createRequest.getDataIda());
        ticket.setDataVolta(createRequest.getDataVolta());
        ticket.setUserId(createRequest.getUserId());
        return ticketRepository.save(ticket);
    }

    public Ticket update(TicketUpdateRequest ticketUpdateRequest, Long id) {

        Ticket oldTicket = ticketRepository.getById(id);
        oldTicket.setPassager(ticketUpdateRequest.getPassager());
        oldTicket.setCpf(ticketUpdateRequest.getCpf());
        oldTicket.setOrigin(ticketUpdateRequest.getOrigin());
        oldTicket.setDestiny(ticketUpdateRequest.getDestiny());
        oldTicket.setPrice(ticketUpdateRequest.getPrice());
        oldTicket.setDataIda(ticketUpdateRequest.getDataIda());
        oldTicket.setDataVolta(ticketUpdateRequest.getDataVolta());

        return ticketRepository.save(oldTicket);
    }

    public void deleteById( Long id) {
        ticketRepository.deleteById(id);
    }
}
