package com.airbrasil.apirest.domain.request;

import com.airbrasil.apirest.enums.StatusVoo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {

    @Column(name = "origem")
    private String origin;

    @Column(name = "destino")
    private String destiny;

    @NotBlank(message = "Nome do passageiro é obrigatório")
    @Column(name = "passageiro", length = 50)
    @Size(min = 3, max = 50)
    private String passager;

    @Column(nullable = false)
    private Date dataIda;

    private Date dataVolta;

    @Enumerated(EnumType.STRING)
    private StatusVoo statusVoo;
}
