package com.powergleb.dynamika.exception;

public class BookWasntReservedException extends RuntimeException {
    public BookWasntReservedException() {
        super("Вы не брали эту книгу");
    }
}