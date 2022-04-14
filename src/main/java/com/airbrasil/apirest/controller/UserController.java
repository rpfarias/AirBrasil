package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.User;
import com.airbrasil.apirest.domain.request.UserRequest;
import com.airbrasil.apirest.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
@Api(value = "API REST User", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    UserRepository userRepository;

    @ApiOperation(value = "Retorna uma lista de Usuários")
    @GetMapping
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @ApiOperation(value = "Retorna um Usuário por Id")
    @GetMapping("/{id}")
    public User userById(@PathVariable(value = "id") long id) {
        return userRepository.findById(id);
    }

    @ApiOperation(value = "Cria um Usuário")
    @PostMapping
    public User saveUser(@RequestBody @Valid UserRequest request) {
        String encoded = new BCryptPasswordEncoder().encode(request.getPassword());

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoded);
        // 1 - encode no password
        // 2 - relacionar usuario com ROLE_USER
        return userRepository.save(user);
    }

    @ApiOperation(value = "Atualiza um Usuário")
    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @ApiOperation(value = "Deleta um Usuário")
    @DeleteMapping
    public void deleteUser(@RequestBody User user) {
        userRepository.delete(user);
    }
}
