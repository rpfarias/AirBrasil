package com.airbrasil.apirest.domain.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @NotBlank(message = "Nome do passageiro é obrigatório")
    @Column(name = "passageiro")
    @Size(min = 3, max = 50)
    private String passager;

    @NotBlank(message = "CPF é obrigatório")
    @Column(length = 11, unique = true)
    @CPF
    private String cpf;

    @Column(name = "origem")
    private String origin;

    @Column(name = "destino")
    private String destiny;

    @Column(name = "preco")
    private BigDecimal price;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private Date dataIda;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVolta;

    @Column(name = "user_id")
    private Long userId;

    @ToString.Exclude
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

}
