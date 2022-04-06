package com.airbrasil.apirest.domain.model;

import com.airbrasil.apirest.enums.RoleName;
import com.airbrasil.apirest.enums.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_reserva")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome do passageiro é obrigatório")
    @Column(name = "nome_passageiro", length = 50)
    @Size(min = 3, max = 50)
    private String passager;

    private Status status;// criar uma reserva, tem que ter o status? Se sim, ja pode ter um status pré definido?
    //essa regra eu jogo lá no serviço?

    @NegativeOrZero(message = "Informe pelo menos um passageiro")
    @Size(min = 1, max = 350)
    private int quantidadePassageiros;

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

    @Column(name = "preco", length = 50)
    private BigDecimal price;//essa regra eu jogo lá no serviço?

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @ManyToOne(mappedBy = "reservations", fetch = FetchType.LAZY)
//    private Client client;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_reservation_client_rel",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "client_id"))
    private Client clients;
}
