package com.airbrasil.apirest.domain.request;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class UpdateTicketRequest {

    private String origin;

    private String destiny;

    private String passager;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataIda;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVolta;

    private BigDecimal price;
}
