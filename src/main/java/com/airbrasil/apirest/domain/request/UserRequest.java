package com.airbrasil.apirest.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @Email(message = "Email é obrigatório")
    @Column(length = 100, unique = true)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;
}
