package com.airbrasil.apirest.service;

import com.airbrasil.apirest.domain.model.Role;
import com.airbrasil.apirest.domain.model.User;
import com.airbrasil.apirest.domain.request.UserRequest;
import com.airbrasil.apirest.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(@PathVariable(value = "id") long id) {
        return userRepository.findById(id);
    }

    public User createUser(@RequestBody @Valid UserRequest request) {
        String encoded = new BCryptPasswordEncoder().encode(request.getPassword());

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoded);
//        user.setRoles((Set<Role>) request.getRoles());
        // 1 - encode no password
        // 2 - relacionar usuario com ROLE_USER
        return userRepository.save(user);
    }

    public User save(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    public void deleteById(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
