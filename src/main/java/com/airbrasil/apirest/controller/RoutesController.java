package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.Routes;
import com.airbrasil.apirest.service.RoutesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/routes")
@Api(value = "API REST Routes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class RoutesController {

    @Autowired
    private final RoutesService routesService;

    public RoutesController(RoutesService routesService) {
        this.routesService = routesService;
    }

    @ApiOperation(value = "Retorna uma lista de Rotas")
    @GetMapping
    public List<Routes> findAll() {
        return routesService.routesList();
    }

    @ApiOperation(value = "Cria uma Rota")
    @PostMapping
    public ResponseEntity create(@RequestBody Routes routes) {
        routesService.create(routes);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rota criada com sucesso");
    }

    @ApiOperation(value = "Altera uma Rota")
    @PutMapping("/{id}")
    public Routes update(@PathVariable Long id, @RequestBody Routes routes) {
        return routesService.update(routes, id);
    }

    @ApiOperation(value = "Deleta uma Rota")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        routesService.deleteById(id);
    }
}
