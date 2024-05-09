package com.powergleb.dynamika.service;

import com.powergleb.dynamika.dto.CreateReservationDto;
import com.powergleb.dynamika.dto.ReservationInfoDto;
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
    private final ReservationMapper reservationMapper;

    public List<Reservation> getAllBorrows() {
        return reservationRepo.findAll();
    }

    public Reservation startReservation(CreateReservationDto createReservationDto) {
        if (reservationRepo.existsByBookIdAndClientId(createReservationDto.getBookId(), createReservationDto.getClientId())) {
            throw new BookAlreadyReservedException();
        }
        Reservation reservation = reservationMapper.toEntity(createReservationDto);
        reservation.setStartTime(LocalDateTime.now());
        return reservationRepo.saveAndFlush(reservation);
    }

    @Transactional
    public void endReservation(CreateReservationDto createReservationDto) {
        if (!reservationRepo.existsByBookIdAndClientId(createReservationDto.getBookId(), createReservationDto.getClientId())) {
            throw new BookWasntReservedException();
        }
        reservationRepo.deleteByBookIdAndClientId(createReservationDto.getBookId(), createReservationDto.getClientId());
    }

    public List<ReservationInfoDto> getAllReservationsInfo() {
        return reservationRepo.getAllBorrowsInfo();
    }
}