package com.powergleb.dynamika.exception;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException(long id) {
        super("Клиент с id = " + id + " не найден");
    }
}