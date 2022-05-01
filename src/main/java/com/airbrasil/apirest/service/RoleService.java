package com.airbrasil.apirest.service;

import com.airbrasil.apirest.domain.model.Role;
import com.airbrasil.apirest.domain.request.RoleRequest;
import com.airbrasil.apirest.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(long id) {
        return roleRepository.findById(id);
    }

    public Role create(RoleRequest roleRequest) {
        Optional<Role> roleVerificador = roleRepository.findByName(roleRequest.getName());

        if (!roleVerificador.isPresent()) {
            Role role = new Role();
            role.setName(roleRequest.getName());
            return roleRepository.save(role);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("RoleName { %s } já cadastrado.", roleRequest.getName()));
    }

    public Role updateRole(RoleRequest roleRequest, Long id) {

        Role role = roleRepository.getById(id);
        role.setName(roleRequest.getName());
        return roleRepository.save(role);
    }

    public void delete(@PathVariable Long id) {
        roleRepository.deleteById(id);
    }
}
