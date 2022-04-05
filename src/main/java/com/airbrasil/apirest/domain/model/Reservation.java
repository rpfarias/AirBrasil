package com.airbrasil.apirest.domain.model;

import com.airbrasil.apirest.enums.RoleName;
import com.airbrasil.apirest.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_reserva")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RoleName name;

    private Status status;

    private int quantidadePassageiros;

    private String origem;

    private String destino;

    private Date dataIda;

    private Date dataVolta;

    private BigDecimal preco;
}
