package com.powergleb.dynamika.repo;

import com.powergleb.dynamika.dto.reservation.ReservationInfoDto;
import com.powergleb.dynamika.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    boolean existsByBookIdAndClientId(long bookId, long clientId);

    Long deleteByBookIdAndClientId(long bookId, long clientId);

    @Query("select new com.powergleb.dynamika.dto.reservation.ReservationInfoDto(c.firstName, c.lastName, c.patronymic, c.birthday, " +
            "b.name, b.author, b.isbn, re.startTime) " +
            "from Client as c " +
            "join fetch Reservation as re " +
            "on c.id = re.clientId " +
            "join fetch Book as b " +
            "on b.id = re.bookId")
    List<ReservationInfoDto> getAllReservationsInfo();
}