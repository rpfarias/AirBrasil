package com.airbrasil.apirest.repository;

import com.airbrasil.apirest.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
    Optional<User> findOneByUsernameIgnoreCase(String username);
}