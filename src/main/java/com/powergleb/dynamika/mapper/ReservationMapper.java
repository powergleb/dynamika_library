package com.powergleb.dynamika.mapper;

import com.powergleb.dynamika.dto.CreateReservationDto;
import com.powergleb.dynamika.dto.ReservationDto;
import com.powergleb.dynamika.entity.Reservation;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationMapper {

    public static List<ReservationDto> toDtoList(List<Reservation> reservations) {
        List<ReservationDto> dtos = new ArrayList<>();
        for (Reservation reservation : reservations) {
            dtos.add(toDto(reservation));
        }
        return dtos;
    }

    public static Reservation toEntity(CreateReservationDto createReservationDto) {
        Reservation reservation = new Reservation();
        reservation.setBookId(createReservationDto.getBookId());
        reservation.setClientId(createReservationDto.getClientId());
        reservation.setStartTime(LocalDateTime.now()); // Assuming you set start time at creation
        return reservation;
    }

    public static ReservationDto toDto(Reservation reservation) {
        ReservationDto dto = new ReservationDto();
        dto.setId(reservation.getId());
        dto.setBookId(reservation.getBookId());
        dto.setClientId(reservation.getClientId());
        dto.setStartTime(reservation.getStartTime());
        return dto;
    }
}
