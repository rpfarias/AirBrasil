package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.Destiny;
import com.airbrasil.apirest.repository.DestinyRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/destinies")
@Api(value="API REST Destinos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class DestinyController {

    @Autowired
    DestinyRepository destinyRepository;

    @ApiOperation(value="Retorna uma lista de Destinos")
    @GetMapping
    public List<Destiny> destinyList() {
        return destinyRepository.findAll();
    }

    @ApiOperation(value="Retorna um Destino por Id")
    @GetMapping("/{id}")
    public Optional <Destiny> destinyById(@PathVariable (value = "id") long id) {
        return destinyRepository.findById(id);
    }

    @ApiOperation(value="Cria um Destino")
    @PostMapping
    public Destiny createDestiny(@RequestBody @Valid Destiny destiny) {
        return destinyRepository.save(destiny);
    }

    @ApiOperation(value="Atualiza um Destino")
    @PutMapping
    public Destiny updateDestiny(@RequestBody @Valid Destiny destiny) {
        return destinyRepository.save(destiny);
    }

    @ApiOperation(value="Deleta um Destino")
    @DeleteMapping
    public void deleteDestiny(@PathVariable Long id) {
        destinyRepository.deleteById(id);
    }
}
