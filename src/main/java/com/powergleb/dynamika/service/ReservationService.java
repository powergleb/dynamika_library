package com.powergleb.dynamika.service;

import com.powergleb.dynamika.dto.reservation.ReservationCreateDto;
import com.powergleb.dynamika.dto.reservation.ReservationInfoDto;
import com.powergleb.dynamika.entity.Reservation;
import com.powergleb.dynamika.exception.BookAlreadyReservedException;
import com.powergleb.dynamika.exception.BookWasntReservedException;
import com.powergleb.dynamika.mapper.ReservationMapper;
import com.powergleb.dynamika.repo.ReservationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepo reservationRepo;
    private ReservationMapper reservationMapper;

    public List<Reservation> getAllReservations() {
        return reservationRepo.findAll();
    }

    public Reservation startReservation(ReservationCreateDto reservationCreateDto) {
        if (reservationRepo.existsByBookIdAndClientId(reservationCreateDto.getBookId(), reservationCreateDto.getClientId())) {
            throw new BookAlreadyReservedException();
        }
        Reservation reservation = reservationMapper.toEntity(reservationCreateDto);
        reservation.setStartTime(LocalDateTime.now());
        return reservationRepo.saveAndFlush(reservation);
    }

    @Transactional
    public void endReservation(ReservationCreateDto reservationCreateDto) {
        if (!reservationRepo.existsByBookIdAndClientId(reservationCreateDto.getBookId(), reservationCreateDto.getClientId())) {
            throw new BookWasntReservedException();
        }
        reservationRepo.deleteByBookIdAndClientId(reservationCreateDto.getBookId(), reservationCreateDto.getClientId());
    }

    public List<ReservationInfoDto> getAllReservationsInfo() {
        return reservationRepo.getAllReservationsInfo();
    }
}