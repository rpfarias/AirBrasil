package com.airbrasil.apirest.repository;

import com.airbrasil.apirest.domain.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByDestino(String destiny);
    Optional<Ticket> findByOrigem(String origin);

//    Optional<Ticket> findAllByOrigemAndDestino(String from, String to);
//    Optional<Ticket> findAllByOrigemAfterAndDestino(String from, String to);
}
