package com.airbrasil.apirest.domain.model;

import com.airbrasil.apirest.enums.StatusVoo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @NotBlank(message = "Nome do passageiro é obrigatório")
    @Column(name = "passageiro", length = 50)
    @Size(min = 3, max = 50)
    private String passager;

    @Enumerated(EnumType.STRING)
    private StatusVoo statusVoo;

    @Column(nullable = false)
    private Date dataIda;

    private Date dataVolta;

    @Column(name = "user_id")
    private Long userId;

//    @ToString.Exclude
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ticket_id", updatable = false, insertable = false)
//    private User user;

    @JsonBackReference
    @ToString.Exclude
    @ManyToMany(mappedBy = "tickets", fetch = FetchType.LAZY)
    private List<User> users;
}
