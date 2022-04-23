package com.airbrasil.apirest.domain.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
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

    @NotBlank(message = "CPF é obrigatório")
    @Column(length = 11, unique = true)
    @CPF
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    private Date dataIda;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVolta;

    @Column(name = "preco")
    private BigDecimal price;

    @Column(name = "user_id")
    private Long userId;
}
