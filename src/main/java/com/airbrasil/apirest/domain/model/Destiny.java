package com.airbrasil.apirest.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tbl_destino")
public class Destiny {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "destino", nullable = false, unique = true, length = 50)
    @Size(min = 3, max = 50)
    private String nameDestiny;

//    @ManyToMany(mappedBy = "destinies", fetch = FetchType.LAZY)
//    private List<Reservation> reservations;
}
