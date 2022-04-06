package com.airbrasil.apirest.domain.model;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_cliente")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Column(length = 50)
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank(message = "CPF é obrigatório")
    @Column(length = 11, unique = true)
    @CPF
    private String cpf;

    @ToString.Exclude
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Reservation> reservations;
}
