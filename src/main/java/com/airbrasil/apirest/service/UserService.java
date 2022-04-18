package com.airbrasil.apirest.service;

import com.airbrasil.apirest.domain.model.User;
import com.airbrasil.apirest.domain.request.UserRequest;
import com.airbrasil.apirest.enums.RoleName;
import com.airbrasil.apirest.repository.RoleRepository;
import com.airbrasil.apirest.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    public Optional<User> findById(@PathVariable long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByCpf(@PathVariable String cpf) {
        return userRepository.findByCpf(cpf);
    }

    public User createUser(@RequestBody @Valid UserRequest request) {
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

    public User save(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    public void deleteById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
