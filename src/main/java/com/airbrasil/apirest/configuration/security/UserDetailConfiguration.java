package com.airbrasil.apirest.configuration.security;

import com.airbrasil.apirest.domain.model.User;
import com.airbrasil.apirest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserDetailConfiguration implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserDetailConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var lowerCaseUsername = username.toLowerCase();

        var loggedUser = userRepository
                .findOneByUsernameIgnoreCase(lowerCaseUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));

        return new org.springframework.security.core.userdetails
                .User(loggedUser.getUsername(), loggedUser.getPassword(), getAuthorities(loggedUser));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<String> roles = new ArrayList<>();
        user.getRoles().forEach(role -> roles.add(role.getName().name()));
        String[] userRoles = roles.stream().toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(userRoles);
    }
}
