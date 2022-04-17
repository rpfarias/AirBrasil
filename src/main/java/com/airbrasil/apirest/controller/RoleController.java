package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.Role;
import com.airbrasil.apirest.repository.RoleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/roles")
@Api(value="API REST Função", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @ApiOperation(value="Retorna uma lista de Funções")
    @GetMapping
    public List<Role> listRole() {
        return roleRepository.findAll();
    }

    @ApiOperation(value="Retorna uma Função por Id")
    @GetMapping("/{id}")
    public Optional<Role> findById(@PathVariable (value = "id") long id) {
        return roleRepository.findById(id);
    }

    @ApiOperation(value="Cria uma Função")
    @PostMapping
    public Role createRole(@RequestBody @Valid Role role) {
        return roleRepository.save(role);
    }

    @ApiOperation(value="Altera uma Função")
    @PutMapping
    public Role updateRole(@RequestBody @Valid Role role) {
        return roleRepository.save(role);
    }

    @ApiOperation(value="Deleta uma Função")
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleRepository.deleteById(id);
    }
}
