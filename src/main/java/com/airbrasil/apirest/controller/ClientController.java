package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.Client;
import com.airbrasil.apirest.repository.ClientRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/clients")
@Api(value="API REST Client", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @ApiOperation(value="Retorna uma lista de Clientes")
    @GetMapping
    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    @ApiOperation(value="Retorna uma Cliente por Id")
    @GetMapping("/{id}")
    public Optional<Client> clientById(@PathVariable (value = "id") long id) {
        return clientRepository.findById(id);
    }

    @ApiOperation(value="Cria um Cliente")
    @PostMapping
    public Client createCliente(@RequestBody @Valid Client client) {
        return clientRepository.save(client);
    }

    @ApiOperation(value="Atualiza um Cliente")
    @PutMapping
    public Client updateCliente(@RequestBody @Valid Client client) {
        return clientRepository.save(client);
    }

    @ApiOperation(value="Deleta um Cliente")
    @DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}
