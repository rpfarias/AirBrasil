package com.airbrasil.apirest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_rotas")
public class Routes {

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
