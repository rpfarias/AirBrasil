package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.repository.UserRepository;
import com.airbrasil.apirest.domain.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST User")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value="Retorna uma lista de Usuários")
    @GetMapping("/users")
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @ApiOperation(value="Retorna um Usuário por Id")
    @GetMapping("/user/{id}")
    public User userById(@PathVariable (value = "id") long id) {
        return userRepository.findById(id);
    }

    @ApiOperation(value="Cria um Usuário")
    @PostMapping("/user")
    public User saveUser(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value="Atualiza um Usuário")
    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value="Deleta um Usuário")
    @DeleteMapping("/user")
    public void deleteUser(@RequestBody User user) {
        userRepository.delete(user);
    }
}
