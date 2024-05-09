package com.powergleb.dynamika.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "reservations")
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "book_id")
    private long bookId;
    @Column(name = "client_id")
    private long clientId;
    @Column(name = "start_time")
    private LocalDateTime startTime;

}