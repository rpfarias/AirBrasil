package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.User;
import com.airbrasil.apirest.domain.request.UserRequest;
import com.airbrasil.apirest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/users")
@Api(value = "API REST User", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "Retorna uma lista de Usuários")
    @GetMapping
    public List<User> listUser() {
        return userService.findAll();
    }

    @ApiOperation(value = "Retorna um Usuário por Id")
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @ApiOperation(value = "Retorna um Usuário por CPF")
    @GetMapping("/cpf/{cpf}")
    public Optional<User> findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @ApiOperation(value = "Cria um Usuário")
    @PostMapping
    public User createUser(@RequestBody UserRequest user) {
        return userService.createUser(user);
    }

    @ApiOperation(value = "Atualiza um Usuário")
    @PutMapping
    public User updateUser(@RequestBody @Valid User user) {
        return userService.save(user);
    }

    @ApiOperation(value = "Deleta um Usuário")
    @DeleteMapping
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
