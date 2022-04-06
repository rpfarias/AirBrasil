package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.Client;
import com.airbrasil.apirest.domain.model.Destiny;
import com.airbrasil.apirest.repository.DestinyRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Destinos")
public class DestinyController {

    @Autowired
    DestinyRepository destinyRepository;

    @ApiOperation(value="Retorna uma lista de Destinos")
    @GetMapping("/destinies")
    public List<Destiny> destinyList() {
        return destinyRepository.findAll();
    }

    @ApiOperation(value="Retorna um Destino por Id")
    @GetMapping("/destiny/{id}")
    public Optional <Destiny> destinyById(@PathVariable (value = "id") long id) {
        return destinyRepository.findById(id);
    }

    @ApiOperation(value="Retorna um Destino por Id")
    @PostMapping("/destiny")
    public Destiny createDestiny(@RequestBody @Valid Destiny destiny) {
        return destinyRepository.save(destiny);
    }

    @ApiOperation(value="Atualiza um Destino")
    @PutMapping("/destiny")
    public Destiny updateDestiny(@RequestBody @Valid Destiny destiny) {
        return destinyRepository.save(destiny);
    }

    @ApiOperation(value="Deleta um Destino")
    @DeleteMapping("/destiny")
    public void deleteDestiny(@RequestBody @Valid Destiny destiny) {
        destinyRepository.delete(destiny);
    }
}
