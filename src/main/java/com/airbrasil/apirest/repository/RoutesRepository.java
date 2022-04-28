package com.airbrasil.apirest.repository;

import com.airbrasil.apirest.domain.model.Routes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutesRepository extends JpaRepository<Routes, String> {
    Routes deleteById(Long id);
}
