package com.airbrasil.apirest.service;

import com.airbrasil.apirest.domain.model.User;
import com.airbrasil.apirest.domain.request.UserRequest;
import com.airbrasil.apirest.enums.RoleName;
import com.airbrasil.apirest.repository.RoleRepository;
import com.airbrasil.apirest.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public User findById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User { %s } not found ID.", id)));
    }

    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User { %s } not found CPF.", cpf)));
    }

    public User createUser(UserRequest request) {
        Optional<User> userVerificador = userRepository.findByCpf(request.getCpf());
        if (!userVerificador.isPresent()) {
            String encoded = new BCryptPasswordEncoder().encode(request.getPassword());

            User user = new User();
            user.setUsername(request.getUsername().toLowerCase().trim());
            user.setPassword(encoded);
            user.setCpf(request.getCpf().trim());
            user.setName(request.getName());
            var role = roleRepository.findByName(RoleName.ROLE_USER);
            role.ifPresent(value -> user.getRoles().add(value));
            return userRepository.save(user);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("CPF { %s } já cadastrado.", request.getCpf()));
    }

    public User update(UserRequest request, Long id) {
        User oldUser = userRepository.getById(id);
        oldUser.setUsername(request.getUsername());
        oldUser.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
        oldUser.setCpf(request.getCpf());
        oldUser.setName(request.getName());
        return userRepository.save(oldUser);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
