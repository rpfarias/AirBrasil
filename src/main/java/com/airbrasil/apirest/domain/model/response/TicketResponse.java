package com.airbrasil.apirest.domain.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {

    private String passager;

    private String origin;

    private String destiny;

    private Date dataIda;

    private Date dataVolta;

    private BigDecimal price;
}
