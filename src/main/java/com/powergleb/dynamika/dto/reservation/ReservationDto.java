package com.powergleb.dynamika.dto.reservation;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ReservationDto {

    private long id;
    private long bookId;
    private long clientId;
    private LocalDateTime startTime;

}