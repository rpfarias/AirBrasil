package com.airbrasil.apirest.repository;

import com.airbrasil.apirest.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
