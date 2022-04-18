package com.airbrasil.apirest.repository;

import com.airbrasil.apirest.enums.StatusVoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<StatusVoo, Long> {
    Optional<StatusVoo> findByStatus(StatusVoo statusVoo);
}
