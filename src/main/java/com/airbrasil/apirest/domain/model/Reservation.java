package com.airbrasil.apirest.domain.model;

import com.airbrasil.apirest.enums.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "Nome do passageiro é obrigatório")
    @Column(name = "passageiro", length = 50)
    @Size(min = 3, max = 50)
    private String passager;

    @Enumerated(EnumType.STRING)
    private Status status;// criar uma reserva, tem que ter o status? Se sim, ja pode ter um status pré definido?
    //essa regra eu jogo lá no serviço?

    @NegativeOrZero(message = "Informe pelo menos um passageiro")
    @Size(min = 1, max = 350)
    private Long quantidadePassageiros;

    @NotBlank(message = "Informe uma origem")
    @Column(name = "origem", length = 50)
    @Size(min = 3, max = 50)
    private String origin;

    @Column(name = "destino", length = 50)
    @Size(min = 3, max = 50)
    private String destiny;


    @Column(nullable = false)
    private Date dataIda;

    private Date dataVolta;

    @Column(name = "user_id")
    private Long userId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", updatable = false, insertable = false)
    private Client client;
}
