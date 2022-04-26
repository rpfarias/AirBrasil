package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.Role;
import com.airbrasil.apirest.domain.request.RoleRequest;
import com.airbrasil.apirest.service.RoleService;
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
    final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @ApiOperation(value="Retorna uma lista de Funções")
    @GetMapping
    public List<Role> listRole() {
        return roleService.findAll();
    }

    @ApiOperation(value="Retorna uma Função por Id")
    @GetMapping("/{id}")
    public Optional<Role> findById(@PathVariable (value = "id") long id) {
        return roleService.findById(id);
    }

    @ApiOperation(value="Cria uma Função")
    @PostMapping
    public Role create(@RequestBody RoleRequest roleRequest) {
        return roleService.create(roleRequest);
    }

    @ApiOperation(value="Altera uma Função")
    @PutMapping("/{id}")
    public Role update(@PathVariable Long id, @RequestBody @Valid RoleRequest roleRequest) {
        return roleService.updateRole(roleRequest, id);
    }

    @ApiOperation(value="Deleta uma Função")
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.delete(id);
    }
}
