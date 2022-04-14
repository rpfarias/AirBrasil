package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.Client;
import com.airbrasil.apirest.repository.ClientRepository;
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
@Api(value="API REST Client")
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @ApiOperation(value="Retorna uma lista de Clientes")
    @GetMapping("/clients")
    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    @ApiOperation(value="Retorna uma Cliente por Id")
    @GetMapping("/client/{id}")
    public Optional<Client> clientById(@PathVariable (value = "id") long id) {
        return clientRepository.findById(id);
    }

    @ApiOperation(value="Cria um Cliente")
    @PostMapping("/client")
    public Client save(@RequestBody @Valid Client client) {
        return clientRepository.save(client);
    }

    @ApiOperation(value="Atualiza um Cliente")
    @PutMapping("/client")
    public Client update(@RequestBody @Valid Client client) {
        return clientRepository.save(client);
    }

    @ApiOperation(value="Deleta um Cliente")
    @DeleteMapping("/client")
    public void delete(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }
}
