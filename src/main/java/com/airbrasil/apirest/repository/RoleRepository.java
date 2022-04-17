package com.airbrasil.apirest.repository;

import com.airbrasil.apirest.domain.model.Role;
import com.airbrasil.apirest.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}