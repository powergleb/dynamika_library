package com.powergleb.dynamika.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(long id) {
        super("Книга с id = " + id + " не найдена");
    }
}