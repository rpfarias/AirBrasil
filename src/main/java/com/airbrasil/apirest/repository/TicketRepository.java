package com.airbrasil.apirest.repository;

import com.airbrasil.apirest.domain.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByDestiny(String destiny);
    List<Ticket> findByOrigin(String origin);
    List<Ticket> findByPassager(String passager);
}
