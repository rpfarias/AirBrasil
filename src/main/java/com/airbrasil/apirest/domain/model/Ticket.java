package com.airbrasil.apirest.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name = "origem")
    private String origin;

    @Column(name = "destino")
    private String destiny;

    @Column(name = "preco")
    private BigDecimal price;
}
