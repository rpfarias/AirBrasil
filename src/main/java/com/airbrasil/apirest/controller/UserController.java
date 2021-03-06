package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.User;
import com.airbrasil.apirest.domain.request.UserRequest;
import com.airbrasil.apirest.domain.request.UserRoleUpdateRequest;
import com.airbrasil.apirest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@Api(value = "API REST User", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private final UserService userService;

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
    public User findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @ApiOperation(value = "Retorna um Usuário por CPF")
    @GetMapping("/cpf/{cpf}")
    public User findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @ApiOperation(value = "Cria um Usuário")
    @PostMapping
    public ResponseEntity createUser(@RequestBody UserRequest user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User criado com sucesso");
    }

    @ApiOperation(value = "Atualiza um Usuário")
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody @Valid UserRequest userRequest) {
        return userService.update(userRequest, id);
    }

    @ApiOperation(value = "Cria permissão no Usuário")
    @PostMapping("/role/{id}")
    public User createRoleUser(@PathVariable Long id, @RequestBody @Valid UserRoleUpdateRequest userRequest) {
        return userService.createRoleUser(userRequest, id);
    }

    @ApiOperation(value = "Deleta um Usuário")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @ApiOperation(value = "Atualiza permissão do Usuário")
    @PutMapping("/role/{id}")
    public void deleteRoleUser(@PathVariable Long id, @RequestBody UserRoleUpdateRequest userRequest) {
        userService.deleteRoleUser(userRequest, id);
    }
}
