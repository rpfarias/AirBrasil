package com.airbrasil.apirest.service;

import com.airbrasil.apirest.domain.model.User;
import com.airbrasil.apirest.domain.request.CreateUserRequest;
import com.airbrasil.apirest.domain.request.UpdateUserRequest;
import com.airbrasil.apirest.enums.RoleName;
import com.airbrasil.apirest.repository.RoleRepository;
import com.airbrasil.apirest.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(@PathVariable long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User { %s } not found.", id)));
    }

    public User findByCpf(@PathVariable String cpf) {
        return userRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User { %s } not found.", cpf)));
    }

    public User createUser(@RequestBody @Valid CreateUserRequest request) {
        String encoded = new BCryptPasswordEncoder().encode(request.getPassword());

        User user = new User();
        user.setUsername(request.getUsername().toLowerCase().trim());
        user.setPassword(encoded);
        user.setCpf(request.getCpf().trim());
        user.setName(request.getName());
        var role = roleRepository.findByName(RoleName.ROLE_USER);
        role.ifPresent(value -> user.getRoles().add(value));

        return userRepository.save(user);
    }

    public User update(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    public void deleteById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
