package com.airbrasil.apirest.controller;

import com.airbrasil.apirest.domain.model.Reservation;
import com.airbrasil.apirest.repository.ReservationRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Reservation")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @ApiOperation(value="Retorna uma lista de Reservas")
    @GetMapping("/reservations")
    public List<Reservation> listReservation() {
        return reservationRepository.findAll();
    }

    @ApiOperation(value="Retorna uma Reserva por Id")
    @GetMapping("/reservation/{id}")
    public Optional<Reservation> reservation(@PathVariable(value = "id") long id) {
        return reservationRepository.findById(id);
    }

    @ApiOperation(value="Cria uma Reserva")
    @PostMapping("/reservation")
    public Reservation createReservation(@RequestBody @Valid Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @ApiOperation(value="Atualiza uma Reserva")
    @PutMapping("/reservation")
    public Reservation updateReservation(@RequestBody @Valid Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @ApiOperation(value="Deleta uma Reserva")
    @DeleteMapping("/reservation")
    public void deleteReservation(@RequestBody @Valid Reservation reservation) {
        reservationRepository.delete(reservation);
    }
}
