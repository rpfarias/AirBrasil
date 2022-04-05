package com.airbrasil.apirest.domain.model;

import com.airbrasil.apirest.enums.RoleName;
import com.airbrasil.apirest.enums.Status;
import lombok.*;

import javax.persistence.*;
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

    private RoleName name;

    private Status status;

    private int quantidadePassageiros;

    private String origem;

    private String destino;

    private Date dataIda;

    private Date dataVolta;

    private BigDecimal preco;

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
