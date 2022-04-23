package com.airbrasil.apirest.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

    @NotBlank(message = "CPF é obrigatório")
    @Column(length = 11, unique = true)
    @CPF
    private String cpf;

    @NotBlank(message = "Nome é obrigatório")
    @Column(name = "nome")
    @Size(min = 3, max = 50)
    private String name;
}
