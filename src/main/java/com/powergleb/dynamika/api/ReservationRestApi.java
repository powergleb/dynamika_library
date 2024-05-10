package com.powergleb.dynamika.api;


import com.powergleb.dynamika.dto.reservation.ReservationCreateDto;
import com.powergleb.dynamika.dto.reservation.ReservationDto;
import com.powergleb.dynamika.dto.reservation.ReservationInfoDto;
import com.powergleb.dynamika.mapper.ReservationMapper;
import com.powergleb.dynamika.service.ReservationService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest-api-reservations")
@RequiredArgsConstructor
public class ReservationRestApi {

    private final ReservationService reservationService;
    private ReservationMapper reservationMapper = new ReservationMapper();


    @GetMapping("/getAllReservations")
    public ResponseEntity<List<ReservationDto>> getAllReservations() {
        return ResponseEntity.ok(reservationMapper.toDtoList(reservationService.getAllReservations()));
    }


    @PostMapping("/startReservation")
    public ResponseEntity<ReservationDto> startReservation(@Valid @RequestBody ReservationCreateDto createReservationDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationMapper.toDto(reservationService.startReservation(createReservationDto)));
    }


    @DeleteMapping("/endReservation")
    public ResponseEntity<ReservationDto> endReservation(@Valid @RequestBody ReservationCreateDto createReservationDto) {
        reservationService.endReservation(createReservationDto);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getDetailedReservations")
    public ResponseEntity<List<ReservationInfoDto>> getDetailedReservations() {
        return ResponseEntity.ok(reservationService.getAllReservationsInfo());
    }

}