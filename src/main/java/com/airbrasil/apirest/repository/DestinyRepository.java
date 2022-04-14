package com.airbrasil.apirest.repository;

import com.airbrasil.apirest.domain.model.Destiny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinyRepository extends JpaRepository<Destiny, Long> {
}
