package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.Reservation;
import com.airbrasil.apirest.repository.ReservationRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/reservations")
@Api(value = "API REST Reservas", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @ApiOperation(value="Retorna uma lista de Reservas")
    @GetMapping
    public List<Reservation> listReservation() {
        return reservationRepository.findAll();
    }

    @ApiOperation(value="Retorna uma Reserva por Id")
    @GetMapping("/{id}")
    public Optional<Reservation> reservationById(@PathVariable(value = "id") long id) {
        return reservationRepository.findById(id);
    }

    @ApiOperation(value="Cria uma Reserva")
    @PostMapping
    public Reservation createReservation(@RequestBody @Valid Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @ApiOperation(value="Atualiza uma Reserva")
    @PutMapping
    public Reservation updateReservation(@RequestBody @Valid Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @ApiOperation(value="Deleta uma Reserva")
    @DeleteMapping
    public void deleteReservation(@PathVariable Long id) {
        reservationRepository.deleteById(id);
    }
}
