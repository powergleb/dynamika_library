package com.powergleb.dynamika.exception;

public class BookAlreadyReservedException extends RuntimeException {
    public BookAlreadyReservedException() {
        super("Вы уже взяли эту книгу");
    }
}